package com.csetutorials.chess;

public class Board {

	private Piece[][] board;

	public Board() {
		initialize();
	}

	private void initialize() {
		this.board = new Piece[8][8];
		
		board[0][0] = new Rook(false);
		board[0][1] = new Knight(false);
		board[0][2] = new Bishop(false);
		board[0][3] = new Queen(false);
		board[0][4] = new King(false);
		board[0][5] = new Bishop(false);
		board[0][6] = new Knight(false);
		board[0][7] = new Rook(false);
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(false);
		}

		board[7][0] = new Rook(true);
		board[7][1] = new Knight(true);
		board[7][2] = new Bishop(true);
		board[7][3] = new Queen(true);
		board[7][4] = new King(true);
		board[7][5] = new Bishop(true);
		board[7][6] = new Knight(true);
		board[7][7] = new Rook(true);
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(true);
		}
	}

	public void print() {
	
		String format = "| %10s | %10s | %10s |  %10s | %10s | %10s | %10s | %10s |";
		for (int i = 0; i < 8; i++) {
			System.out.println(String.format(format, board[i]));
		}
		
	}

	public Piece getPiece(int row, int column) {
		return this.board[row][column];
	}

	public void move(Move move) {
		Piece piece = board[move.getSrcRow()][move.getSrcColumn()];
		if (!piece.canMove(move)) {
			throw new InvalidMoveException();
		}
		board[move.getSrcRow()][move.getSrcColumn()] = null;
		board[move.getTargetRow()][move.getTargetColumn()] = piece;
	}
	
}
