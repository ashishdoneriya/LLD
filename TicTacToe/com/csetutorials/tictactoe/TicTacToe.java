package com.csetutorials.tictactoe;

public class TicTacToe {

	private int size;
	private final int[][] board;
	private final int players;

	private int currentPlayer = 1;

	private int filledPositions = 0;

	private int winnerPlayerNumber = 0;

	private int[] lastPlayerRow;
	private int[] lastPlayerRowCount;
	private int[] lastPlayerColumn;
	private int[] lastPlayerColumnCount;
	private int lastPlayerDiagonal;
	private int lastPlayerDiagonalCount;
	private int lastPlayerRevDiagonal;
	private int lastPlayerRevDiagonalCount;

	public TicTacToe(int size, int players) {
		this.size = size;
		this.board = new int[size][size];
		this.players = players;
		this.lastPlayerRow = new int[size];
		this.lastPlayerRowCount = new int[size];
		this.lastPlayerColumn = new int[size];
		this.lastPlayerColumnCount = new int[size];

	}

	/**
	 * 
	 * @param row board row number, starts from 0 upto size - 1
	 * @param column board column number, starts from 0 upto size - 1
	 * @return whether the player wins or not
	 * @throws IllegalArgumentException
	 */
	public boolean move(int row, int column) throws IllegalArgumentException {
		if (row < 0 || column < 0 || row >= this.size || column >= this.size) {
			throw new IllegalArgumentException("Provided position is out of board");
		} 
		if (this.board[row][column] != 0) {
			throw new IllegalArgumentException("Position already occupied");
		}
		if (this.winnerPlayerNumber != 0) {
			throw new IllegalArgumentException("Ther is already a winner");
		}
		this.board[row][column] = this.currentPlayer;
		this.filledPositions++;
		if (this.lastPlayerRow[row] == 0 || this.lastPlayerRow[row] == this.currentPlayer) {
			this.lastPlayerRow[row] = this.currentPlayer;
			this.lastPlayerRowCount[row]++;
			if (this.lastPlayerRowCount[row] == this.size) {
				this.winnerPlayerNumber = this.currentPlayer;
				return true;
			}
		} else {
			this.lastPlayerRow[row] = -1;
		}
		if (this.lastPlayerColumn[column] == 0 || this.lastPlayerColumn[column] == this.currentPlayer) {
			this.lastPlayerColumn[column] = this.currentPlayer;
			this.lastPlayerColumnCount[column]++;
			if (this.lastPlayerColumnCount[column] == this.size) {
				this.winnerPlayerNumber = this.currentPlayer;
				return true;
			}
		} else {
			this.lastPlayerColumn[column] = -1;
		}
		if (row == column) {
			if (this.lastPlayerDiagonal == 0 || this.lastPlayerDiagonal == this.currentPlayer) {
				this.lastPlayerDiagonal = this.currentPlayer;
				this.lastPlayerDiagonalCount++;
				if (this.lastPlayerDiagonalCount == this.size) {
					this.winnerPlayerNumber = this.currentPlayer;
					return true;
				}
			}
		}
		if (row == this.size - 1 - column) {
			if (this.lastPlayerRevDiagonal == 0 || this.lastPlayerRevDiagonalCount == this.currentPlayer) {
				this.lastPlayerRevDiagonal = this.currentPlayer;
				this.lastPlayerRevDiagonalCount++;
				if (this.lastPlayerRevDiagonalCount == this.size) {
					this.winnerPlayerNumber = this.currentPlayer;
					return true;
				}
			}
		}
		this.currentPlayer++;
		if (this.currentPlayer == this.players + 1) {
			this.currentPlayer = 1;
		}
		return false;
	}

	public boolean isBoardFull() {
		return this.filledPositions == this.size * this.size;
	}

	public int getWinner() {
		return this.winnerPlayerNumber;
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe(3, 2);
		game.move(0, 0);
		game.move(0, 2);
		game.move(2, 0);
		game.move(2, 2);
		game.move(1, 0);
		System.out.println(game.getWinner());
	
	}

}