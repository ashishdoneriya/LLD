package com.csetutorials.tictactoe.v2;

public class Player extends User {
	
	private Piece piece;

	public Player(String name, String userId, Piece piece) {
		super(name, userId);
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

}
