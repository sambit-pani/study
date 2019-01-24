package com.example.rest.webservice.exception;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private String details;
	private Date date;
	public ExceptionResponse(String message, String details, Date date) {
		super();
		this.message = message;
		this.details = details;
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public Date getDate() {
		return date;
	}
	
	
}
