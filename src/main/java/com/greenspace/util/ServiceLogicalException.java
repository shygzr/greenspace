package com.greenspace.util;

public class ServiceLogicalException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServiceLogicalException() {
		super();
	}

	public ServiceLogicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceLogicalException(String message) {
		super(message);
	}

	public ServiceLogicalException(Throwable cause) {
		super(cause);
	}

}
