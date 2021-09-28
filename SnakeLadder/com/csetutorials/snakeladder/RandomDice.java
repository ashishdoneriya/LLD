package com.csetutorials.snakeladder;

public class RandomDice extends Dice {

	public RandomDice(int size) {
		super(size);
	}

	@Override
	public int roll() {
		return ((int) (Math.random() * 100) % super.getSize()) + 1;
	}
	
}
