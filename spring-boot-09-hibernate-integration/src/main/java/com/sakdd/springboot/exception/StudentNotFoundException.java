package com.sakdd.springboot.exception;

public class StudentNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;
	
	public String getExceptionMessage() 
	{
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) 
	{
		this.exceptionMessage = exceptionMessage;
	}

	public StudentNotFoundException(String exceptionMessage)
	{
		super(exceptionMessage);
		this.exceptionMessage=exceptionMessage;
	}
}
