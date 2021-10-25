package com.csetutorials.snakeladder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Dice {

	private int size;
	
	public abstract int roll();

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Dice(int size) {
		this.setSize(size);
	}

}
