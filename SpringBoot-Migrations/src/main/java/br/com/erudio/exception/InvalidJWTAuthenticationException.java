package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJWTAuthenticationException extends AuthenticationException {

	@Serial
	private static final long serialVersionUID = 1L;

	public InvalidJWTAuthenticationException(String exception) {
		super(exception);
	}

}
