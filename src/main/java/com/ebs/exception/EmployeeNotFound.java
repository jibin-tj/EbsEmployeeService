package com.ebs.exception;

public class EmployeeNotFound extends RuntimeException {
	public EmployeeNotFound(final String message, final Throwable cause) {
		super(message, cause);
	}

	public EmployeeNotFound(final String message) {
		super(message);
	}

	public EmployeeNotFound() {
		super();
	}
}
