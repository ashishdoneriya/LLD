package com.csetutorials.chess;

public class Move {

	private int srcRow;
	private int srcColumn;
	private int targetRow;
	private int targetColumn;
	private Piece pieceKilled;
	private Piece pieceMoved;
	private Player player;

	public Move(int srcRow, int srcColumn, int targetRow, int targetColumn) {
		this.srcRow = srcRow;
		this.srcColumn = srcColumn;
		this.targetRow = targetRow;
		this.targetColumn = targetColumn;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Piece getPieceMoved() {
		return pieceMoved;
	}

	public void setPieceMoved(Piece pieceMoved) {
		this.pieceMoved = pieceMoved;
	}

	public Piece getPieceKilled() {
		return pieceKilled;
	}

	public void setPieceKilled(Piece pieceKilled) {
		this.pieceKilled = pieceKilled;
	}

	public int getTargetColumn() {
		return targetColumn;
	}

	public void setTargetColumn(int targetColumn) {
		this.targetColumn = targetColumn;
	}

	public int getTargetRow() {
		return targetRow;
	}

	public void setTargetRow(int targetRow) {
		this.targetRow = targetRow;
	}

	public int getSrcColumn() {
		return srcColumn;
	}

	public void setSrcColumn(int srcColumn) {
		this.srcColumn = srcColumn;
	}

	public int getSrcRow() {
		return srcRow;
	}

	public void setSrcRow(int srcRow) {
		this.srcRow = srcRow;
	}

}
