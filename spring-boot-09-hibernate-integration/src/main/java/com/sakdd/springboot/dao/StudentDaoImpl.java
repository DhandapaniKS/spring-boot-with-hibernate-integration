package com.sakdd.springboot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sakdd.springboot.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Student> students = session.createCriteria(Student.class).list();
		return students;
	}

	@Override
	public Student getStudentById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		return student;
	}

	@Override
	public Student saveStudent(Student student)
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) 
	{
		Session session = sessionFactory.getCurrentSession();
		Student foundStudent = session.get(Student.class, student.getId());
		foundStudent.setId(student.getId());
		foundStudent.setName(student.getName());
		foundStudent.setDepartment(student.getDepartment());
		session.update(foundStudent);
		return student;
	}

	@Override
	public String deleteStudentById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Student foundStudent = session.get(Student.class, id);
		session.delete(foundStudent);
		return "Deleted Successfully";
	}
}
