package com.jsp.bootcrud.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private int statusecode;
	private String message;
	private T data;
	

}
