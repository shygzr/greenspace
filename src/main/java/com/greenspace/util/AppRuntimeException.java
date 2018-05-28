package com.greenspace.util;

public class AppRuntimeException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4823772842378630950L;
	public AppRuntimeException() {
        super();
    } 
    public AppRuntimeException(String s) {
        super(s);
    }
    public AppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    public AppRuntimeException(Throwable cause) {
        super(cause);
    } 

}
