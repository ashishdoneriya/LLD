package com.csetutorials.chess;

public abstract class Piece {
	private boolean isWhitePiece;
	private String name;
	
	public Piece(boolean isWhitePiece, String name) {
		this.isWhitePiece = isWhitePiece;
		this.name = name;
	}

	public boolean isPieceColorWhite() {
		return this.isWhitePiece;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return (isWhitePiece ? "W-" : "B-") + name;
	}

	public abstract boolean canMove(Board board, Move move);

}
