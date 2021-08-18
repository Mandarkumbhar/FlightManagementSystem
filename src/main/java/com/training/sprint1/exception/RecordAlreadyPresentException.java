package com.training.sprint1.exception;

public class RecordAlreadyPresentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RecordAlreadyPresentException(String s) {
		super(s);
	}
}