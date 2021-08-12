package com.training.sprint1.exception;

public class FlightNotFoundException extends Exception {
	
	private String msg;
	
	public FlightNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	public FlightNotFoundException() {
		super();
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "FlightNotFoundException [msg=" + msg + "]";
	}
	
	
	
}