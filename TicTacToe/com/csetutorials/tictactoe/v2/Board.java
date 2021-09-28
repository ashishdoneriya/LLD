package com.csetutorials.tictactoe.v2;

public class Board {
	
	public Cell[][] boxes;
	private int noOfCells;
	
	public Board(int noOfCells) {
		this.noOfCells = noOfCells;
		this.boxes = new Cell[noOfCells][noOfCells];
		initializeBoard();
	}

	public Cell[][] getBoxes() {
		return this.boxes;
	}

	public void printBoard() {
		for (int row = 0; row < this.noOfCells; row++) {
			for (int column = 0; column < this.noOfCells; column++) {
				System.out.print(this.boxes[row][column] + " ");
			}
			System.out.println();
		}
	}

	private void initializeBoard() {
		for (int row = 0; row < this.noOfCells; row++) {
			for (int column = 0; column < this.noOfCells; column++) {
				this.boxes[row][column] = new Cell(row, column, null);
			}
		}
	}

}
