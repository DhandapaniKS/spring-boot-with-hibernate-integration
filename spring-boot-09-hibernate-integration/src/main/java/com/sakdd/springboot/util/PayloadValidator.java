package com.sakdd.springboot.util;

import com.sakdd.springboot.model.Student;

public class PayloadValidator
{
	public static boolean validatePayload(Student student)
	{
		if(student.getId() > 0)
			return false;
		else
			return true;
	}
}
