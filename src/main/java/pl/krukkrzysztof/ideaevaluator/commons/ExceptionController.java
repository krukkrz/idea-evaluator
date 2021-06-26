package pl.krukkrzysztof.ideaevaluator.commons;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionController { 

	@ResponseStatus(value = NOT_FOUND, reason = "No such entity")
	@ExceptionHandler(EntityNotFoundException.class)
	public void notFound() {
	}

	@ResponseStatus(value = BAD_REQUEST, reason = "Your request is baaad...")
	@ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
	public void badRequest() {
	}
}