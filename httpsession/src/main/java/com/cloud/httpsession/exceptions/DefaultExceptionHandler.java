package com.cloud.httpsession.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(value=InterruptedException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(InterruptedException e) {
		ErrorMessage errMsg = new ErrorMessage("THREADCODE", e.getMessage());
		return ResponseEntity.ok(errMsg);
	}
}
