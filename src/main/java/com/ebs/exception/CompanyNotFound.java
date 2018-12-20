package com.ebs.exception;

public class CompanyNotFound extends RuntimeException {

	public CompanyNotFound(final String message, final Throwable cause) {
		super(message, cause);
	}

	public CompanyNotFound(final String message) {
		super(message);
	}

}
