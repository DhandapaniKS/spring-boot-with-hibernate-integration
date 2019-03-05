package com.sakdd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakdd.springboot.dao.StudentDao;
import com.sakdd.springboot.model.Student;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public List<Student> getStudents()
	{
		return studentDao.getStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) 
	{
		return studentDao.getStudentById(id);
	}

	@Override
	@Transactional
	public Student saveStudent(Student student) 
	{
		return studentDao.saveStudent(student);
	}

	@Override
	@Transactional
	public Student updateStudent(Student student)
	{
		return studentDao.updateStudent(student);
	}

	@Override
	@Transactional
	public String deleteStudentById(int id) 
	{
		return studentDao.deleteStudentById(id);
	}
}
