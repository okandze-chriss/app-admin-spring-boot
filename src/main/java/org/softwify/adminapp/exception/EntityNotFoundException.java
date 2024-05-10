package org.softwify.adminapp.exception;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException{
	@Serial
	private static final long serialVersionUID = 1L;
	String message;
	
	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
