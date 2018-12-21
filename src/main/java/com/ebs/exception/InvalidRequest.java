package com.ebs.exception;

public class InvalidRequest extends RuntimeException {
	public InvalidRequest(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InvalidRequest(final String message) {
		super(message);
	}
}
