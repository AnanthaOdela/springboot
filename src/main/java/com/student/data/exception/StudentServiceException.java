package com.student.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class StudentServiceException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	

	public StudentServiceException(String message) {
		super(message);
	}
}