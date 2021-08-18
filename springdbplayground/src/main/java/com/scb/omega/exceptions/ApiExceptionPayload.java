package com.scb.omega.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiExceptionPayload 
{
	String message;
	HttpStatus status;
	Throwable throwable;
	LocalDateTime timestamp;
	String path;
	
	public ApiExceptionPayload(String message, HttpStatus status, Throwable throwable, LocalDateTime timestamp,
			String path) {
		super();
		this.message = formatMessage(message);
		this.status = status;
	//	this.throwable = throwable;
		this.timestamp = timestamp;
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	
/*
	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
*/
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ApiExceptionPayload [message=" + message + ", status=" + status 
				+ ", timestamp=" + timestamp + ", path=" + path + "]";
	}
	
	public String formatMessage(String message)
	{
		System.out.println(message);
		int indexOfDoubleQuotes=message.indexOf("\"");
		message=message.substring(indexOfDoubleQuotes+1);
		message=message.replace("\"","");
		return message;
	}
	
	
	
	
	
	
	

}
