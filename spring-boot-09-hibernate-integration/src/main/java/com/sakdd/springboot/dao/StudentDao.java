package com.sakdd.springboot.dao;

import java.util.List;


import com.sakdd.springboot.model.Student;

public interface StudentDao
{
	public List<Student> getStudents();
	public Student getStudentById(int id);
	public Student saveStudent(Student student);
	public Student updateStudent(Student student);
	public String deleteStudentById(int id);
}
