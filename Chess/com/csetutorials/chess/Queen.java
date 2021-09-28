package com.csetutorials.chess;

public class Queen extends Piece {

	public Queen(boolean isWhitePiece) {
		super(isWhitePiece, "Queen");
	}

	@Override
	public boolean canMove(Board board, Move move) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
