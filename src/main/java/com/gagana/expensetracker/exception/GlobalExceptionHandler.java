package com.gagana.expensetracker.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 404);
        response.put("error", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

	  @ExceptionHandler(EmailAlreadyExistsExcepetion.class)
	    public ResponseEntity<Map<String, Object>> handleEmailExists(EmailAlreadyExistsExcepetion ex) {

	        Map<String, Object> response = new HashMap<>();
	        response.put("timestamp", LocalDateTime.now());
	        response.put("status", 400);
	        response.put("error", ex.getMessage());

	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }
}
