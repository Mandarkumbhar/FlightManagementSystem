package com.training.sprint1.exception;

public class BookingNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String msgs;

	public BookingNotFoundException(String msgs) {
		super();
		this.msgs = msgs;
	}

	public BookingNotFoundException() {
		super();
	}

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

	@Override
	public String toString() {
		return "BookingNotFindException [msgs=" + msgs + "]";
	}
	
	

}
