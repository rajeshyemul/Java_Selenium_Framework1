package com.rajesh.exceptions;

@SuppressWarnings("serial")
public class FileReadException extends FrameworkException{
	
	public FileReadException(String message) {
		super(message);
	}
	
	public FileReadException(String message, Throwable cause) {
		super(message, cause);
	}
}
