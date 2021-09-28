package com.csetutorials.chess;

import java.util.List;
import java.util.ArrayList;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Player currentTurn;
	private List<Move> moves;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = new Board();
		this.currentTurn = this.player1.ownsWhitePieces() ? this.player1 : this.player2;
		this.moves = new ArrayList<>();
	}

	public Player getCurrentPlayer() {
		return this.currentTurn;
	}
	
	public void move(Move move) {
		if (!isValidMove(move)) {
			throw new InvalidMoveException();
		}
		move.setPlayer(this.currentTurn);
		move.setPieceMoved(this.board.getPiece(move.getSrcRow(), move.getSrcColumn()));
		move.setPieceKilled(this.board.getPiece(move.getTargetRow(), move.getTargetColumn()));
		this.board.move(move);
		this.moves.add(move);
		this.currentTurn = (this.currentTurn == this.player1) ? this.player2 : this.player1;
	}

	private boolean isValidMove(Move move) {
		Piece srcPiece = this.board.getPiece(move.getSrcRow(), move.getSrcColumn());
		if (srcPiece == null) {
			return false;
		}
		Piece targetPiece = this.board.getPiece(move.getTargetRow(), move.getTargetColumn());
		if (targetPiece != null) {
			if (srcPiece.isPieceColorWhite() && targetPiece.isPieceColorWhite()) {
				return false;
			}
			if (!srcPiece.isPieceColorWhite() && !targetPiece.isPieceColorWhite()) {
				return false;
			}
		}

		return srcPiece.canMove(this.board, move);
	}
	
}
