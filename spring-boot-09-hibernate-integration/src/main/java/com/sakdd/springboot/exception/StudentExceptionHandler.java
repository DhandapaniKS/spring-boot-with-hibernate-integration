package com.sakdd.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sakdd.springboot.response.ErrorResponse;

@ControllerAdvice
public class StudentExceptionHandler
{
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> studentNotFoundExcpetionHandler(Exception ex)
	{
		ErrorResponse errorResponse =new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PayloadException.class)
	public ResponseEntity<ErrorResponse> payloadExcpetionHandler(Exception ex)
	{
		ErrorResponse errorResponse =new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyStudentListException.class)
	public ResponseEntity<ErrorResponse> emptyStudentListExceptionHandler(Exception ex)
	{
		ErrorResponse errorResponse =new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> gloablExcpetionHandler(Exception ex)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setErrorMessage("The request could not be understood by the server due to malformed syntax.");
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	
	}
}
