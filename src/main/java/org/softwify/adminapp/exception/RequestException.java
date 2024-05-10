package org.softwify.adminapp.exception;
import org.springframework.http.HttpStatus;

import java.io.Serial;

public class RequestException extends RuntimeException{
	@Serial
	private static final long serialVersionUID = 1L;
	String message;
	HttpStatus status;
	
	public RequestException() {
		super();
	}
	
	public RequestException(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
