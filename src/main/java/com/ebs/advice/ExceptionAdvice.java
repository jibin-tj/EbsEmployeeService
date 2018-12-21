package com.ebs.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ebs.exception.CompanyNotFound;
import com.ebs.exception.EmployeeNotFound;
import com.ebs.exception.InvalidRequest;
import com.ebs.model.ErrorDTO;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);
	private static final String COLON = ":";

	private ErrorDTO getError(final Integer code, final String message) {
		final ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setMessage(message);
		errorDTO.setCode(code);
		return errorDTO;
	}

	@ExceptionHandler(EmployeeNotFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorDTO handle(final EmployeeNotFound exception) {
		LOGGER.warn(String.format("%s %s %s", HttpStatus.NOT_FOUND.value(), COLON, exception.getMessage()));
		return getError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}

	@ExceptionHandler(CompanyNotFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorDTO handle(final CompanyNotFound exception) {
		LOGGER.warn(String.format("%s %s %s", HttpStatus.NOT_FOUND.value(), COLON, exception.getMessage()));
		return getError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}

	@ExceptionHandler(InvalidRequest.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorDTO handle(final InvalidRequest exception) {
		LOGGER.warn(String.format("%s %s %s", HttpStatus.BAD_REQUEST.value(), COLON, exception.getMessage()));
		return getError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}

}
