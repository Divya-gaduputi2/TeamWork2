package com.cts.demo.controll;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.demo.Exception.EmployeeException;

@RestControllerAdvice
public class ExceptionAdvisor {
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> handleEmployeeExceptionAction(EmployeeException exp){
		
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExceptionAction(Exception exp){
		exp.printStackTrace();
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
