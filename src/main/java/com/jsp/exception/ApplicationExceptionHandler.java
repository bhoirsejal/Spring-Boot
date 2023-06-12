package com.jsp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jsp.bootcrud.dto.Admin;
import com.jsp.bootcrud.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(value= InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> invalidCredentialException(InvalidCredentialException e){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusecode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(e.getMessage());
		responseStructure.setData(e.getMessage());
		
	  return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

}
