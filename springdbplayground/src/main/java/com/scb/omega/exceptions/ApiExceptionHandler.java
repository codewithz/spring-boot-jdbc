package com.scb.omega.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ApiExceptionHandler 
{
	@ExceptionHandler(value= {ResponseStatusException.class})
	public ResponseEntity<Object> handleApiException(ResponseStatusException e,WebRequest request)
	{
		String path=request.getDescription(false).substring(4);
		// 1. Create a payload containing exception details
			ApiExceptionPayload payload=new ApiExceptionPayload(
					e.getMessage(), 
					e.getStatus(),
					e,
					LocalDateTime.now(),
					path);
					
		// 2. Return the response entity
			return new ResponseEntity<>(payload,e.getStatus());
	}
}
