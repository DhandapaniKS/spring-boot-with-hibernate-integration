package com.sakdd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sakdd.springboot.exception.EmptyStudentListException;
import com.sakdd.springboot.exception.PayloadException;
import com.sakdd.springboot.exception.StudentNotFoundException;
import com.sakdd.springboot.model.Student;
import com.sakdd.springboot.service.StudentService;
import com.sakdd.springboot.util.PayloadValidator;

@RestController
@RequestMapping("studentRestApi")
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> students = studentService.getStudents();
		if(!students.isEmpty())
		{
			return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
		}
		else
		{
			throw new EmptyStudentListException("Students does not exist in the database");
		}
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id)
	{
		Student foundStudent = studentService.getStudentById(id);
		if(foundStudent!=null)
		{
			return new ResponseEntity<Student>(foundStudent,HttpStatus.OK);
		}
		else
		{
			throw new StudentNotFoundException("Student does not exist");
		}
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student payload)
	{
		boolean payloadValiationStatus = PayloadValidator.validatePayload(payload);
		if(payloadValiationStatus)
		{	
			Student savedStudent = studentService.saveStudent(payload);
			return new ResponseEntity<Student>(savedStudent,HttpStatus.OK);
		}
		else
		{
			throw new PayloadException("Malformed Payload, Student id must not be defined");
		}
	}
	
	@RequestMapping(value="/student", method=RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@RequestBody Student payload)
	{
		Student foundStudent = studentService.getStudentById(payload.getId());
		if(foundStudent!=null)
		{
			Student updatedStudent = studentService.updateStudent(payload);
			return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
		}
		else
		{
			throw new StudentNotFoundException("Student to update does not not exist");
		}
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id)
	{
		Student foundStudent = studentService.getStudentById(id);
		if(foundStudent!=null)
		{
		String deleteStatus = studentService.deleteStudentById(id);
		return new ResponseEntity<String>(deleteStatus,HttpStatus.OK);
		}
		else
		{
			throw new StudentNotFoundException("Student to delete does not not exist");
		}
	}
}
