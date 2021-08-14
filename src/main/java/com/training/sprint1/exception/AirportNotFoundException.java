package com.training.sprint1.exception;

public class AirportNotFoundException extends RuntimeException{
	private String message;
	
	public AirportNotFoundException(String msg) {
		super();
		this.message = msg;
	}
	public AirportNotFoundException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "AirportNotFoundException [message=" + message + "]";
	}
	
}
