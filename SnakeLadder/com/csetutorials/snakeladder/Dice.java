package com.csetutorials.snakeladder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Dice {

	private int size;
	
	public abstract int roll();

}
