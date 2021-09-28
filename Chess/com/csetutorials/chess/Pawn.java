package com.csetutorials.chess;

public class Pawn extends Piece {

	public Pawn(boolean isWhitePiece) {
		super(isWhitePiece, "Pawn");
	}

	@Override
	public boolean canMove(Board board, Move move) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
