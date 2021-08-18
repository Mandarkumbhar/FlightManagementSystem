package com.training.sprint1.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public UserNotFoundException() {
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
		return "UserNotFoundException [msg=" + msg + "]";
	}
	
	
}
