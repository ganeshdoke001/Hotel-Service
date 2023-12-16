package com.lcwd.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public  ResourceNotFoundException() {
		super("Hotel with given id not found");
	}
	
	public  ResourceNotFoundException(String message) {
		super(message);
	}
}
