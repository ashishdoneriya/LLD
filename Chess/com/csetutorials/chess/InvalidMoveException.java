package com.csetutorials.chess;

public class InvalidMoveException extends RuntimeException {

	public InvalidMoveException() {
		super();
	}
	
	public InvalidMoveException(String message) {
		super(message);
	}

}