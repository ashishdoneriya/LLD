package com.csetutorials.chess;

public class Player {

	private String name;

	private boolean hasWhitePieces;

	public Player(String name, boolean hasWhitePieces) {
		this.name = name;
		this.hasWhitePieces = hasWhitePieces;
	}

	public String getName() {
		return this.name;
	}

	public boolean ownsWhitePieces() {
		return this.hasWhitePieces;
	}
	
}
