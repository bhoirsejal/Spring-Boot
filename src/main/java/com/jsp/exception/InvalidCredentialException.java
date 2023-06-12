package com.jsp.exception;

public class InvalidCredentialException extends RuntimeException{
  
	private String message="Invalid email or password";
	
	public InvalidCredentialException() {
		
	}
	public InvalidCredentialException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
		
	}
}
