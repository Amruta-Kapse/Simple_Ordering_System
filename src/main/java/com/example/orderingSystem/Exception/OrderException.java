package com.example.orderingSystem.Exception;

public class OrderException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private final String message;
	private final String errorCode;
	
	public OrderException(String message, String errorCode) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}
	
	public OrderException(String message) {
		super(message);
		this.message = message;
		this.errorCode=null;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
