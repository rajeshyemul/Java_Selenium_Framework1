package com.rajesh.exceptions;

@SuppressWarnings("serial")
public class ExcelSheetNotFoundException extends FrameworkException{

	public ExcelSheetNotFoundException(String message) {
		super(message);
	}

	public ExcelSheetNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
