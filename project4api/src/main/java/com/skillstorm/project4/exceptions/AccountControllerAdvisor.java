package com.skillstorm.project4.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AccountControllerAdvisor extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<Object> handleEmailExistsException(
			EmailExistsException e, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.CONFLICT.value());
		body.put("error", HttpStatus.CONFLICT.getReasonPhrase());
		body.put("message", "Email already taken");
		return new ResponseEntity<>(body, HttpStatus.CONFLICT);
	}
	
}
