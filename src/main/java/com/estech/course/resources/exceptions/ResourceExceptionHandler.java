package com.estech.course.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estech.course.services.exceptions.DatabaseException;
import com.estech.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;

/*A anotação @ControllerAdvice é uma funcionalidade do Spring Framework que permite criar um manipulador 
 * global de exceções e outros aspectos transversais dos controladores.
 * 
 * O que é @ControllerAdvice?
É uma especialização da anotação @Component que permite definir métodos que se aplicam a todos os 
controladores da aplicação, não apenas a um controlador específico.
 * */
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), "Not found", e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}
}
