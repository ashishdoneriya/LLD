package com.csetutorials.tictactoe.v2;

public class Cell {
	
	private int row;
	private int column;
	private Piece piece;

	public Cell(int row, int column, Piece piece) {
		this.row = row;
		this.column = column;
		this.piece = piece;
	}

	public int getRow() {
		return row;
	}
	public Piece getPiece() {
		return piece;
	}

	public int getColumn() {
		return column;
	}
	
}
