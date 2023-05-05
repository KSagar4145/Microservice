package com.lced.hotel.hotelservice.exceptionHandler;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource not found on server");
	}

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
