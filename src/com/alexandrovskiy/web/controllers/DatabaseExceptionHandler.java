package com.alexandrovskiy.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseExceptionHandler {
	// handles exceptions for all controllers
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseExceptions(DataAccessException ex) {
		return "error";
	}

}
