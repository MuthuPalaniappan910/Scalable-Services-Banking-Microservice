package com.scalableservices.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scalableservices.customer.dto.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ExceptionResponse> noCategoriesFoundException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Customer Not Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

}
