package com.csetutorials.snakeladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import lombok.NonNull;

@NonNull
public class GameBoard {

	private Queue<Player> playersQueue;
	private Dice dice;
	private Map<Integer, Integer> snakeAndLadderPositions;
	private int boardSize;
	private Map<Player, Integer> playersCurrentPosition;
	private GameStatus gameStatus;
	private Player winner;

	public GameBoard(Queue<Player> playersQueue, Dice dice, Map<Integer, Integer> snakeAndLadderPositions,
			int boardSize) {
		this.playersQueue = playersQueue;
		this.dice = dice;
		this.snakeAndLadderPositions = snakeAndLadderPositions;
		this.boardSize = boardSize;
		initialize();
	}

	public void roll() {
		Player player = this.playersQueue.poll();
		int diceValue = this.dice.roll();
		int currPos = this.playersCurrentPosition.get(player);
		int expectedPos = currPos + diceValue;
		if (expectedPos == this.boardSize) {
			System.out.println(player.getName() + " has won");
			this.gameStatus = GameStatus.FINISHED;
			this.winner = player;
		} else if (expectedPos < this.boardSize) {
			int target = this.snakeAndLadderPositions.getOrDefault(expectedPos, expectedPos);
			if (target > expectedPos) {
				System.out.println(player.getName() + " got ladder");
			} else if (target < expectedPos) {
				System.out.println(player.getName() + " is bitten by the snake");
			}
			this.playersCurrentPosition.put(player, target);
		}
		if (this.gameStatus == GameStatus.IN_PROGRESS) {
			System.out
					.println("Current position of " + player.getName() + " : " + this.playersCurrentPosition.get(player));
		}
		this.playersQueue.offer(player);
	}

	private void initialize() {
		this.playersCurrentPosition = new HashMap<>(playersQueue.size());
		for (Player player : this.playersQueue) {
			this.playersCurrentPosition.put(player, 1);
		}
		this.gameStatus = GameStatus.IN_PROGRESS;
		this.winner = null;
	}

	public GameStatus getGameStatus() {
		return this.gameStatus;
	}

	public Player getWinner() {
		return this.winner;
	}

}
