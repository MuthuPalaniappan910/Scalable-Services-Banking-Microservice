package com.scalableservices.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scalableservices.account.dto.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoAccountFoundException.class)
	public ResponseEntity<ExceptionResponse> noAccountFoundException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("No Account Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(CreateAccountException.class)
	public ResponseEntity<ExceptionResponse> createAccountException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Issue in Create Account");
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exceptionResponse);
	}

}
