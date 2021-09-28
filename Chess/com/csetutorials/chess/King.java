package com.csetutorials.chess;

public class King extends Piece {

	public King(boolean isWhitePiece) {
		super(isWhitePiece, "King");
	}

	@Override
	public boolean canMove(Board board, Move move) {
		return false;
	}
	
}
