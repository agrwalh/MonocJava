package com.assignment.tictactoe.model;

import java.util.Random;

public class ComputerPlayer extends Player {

	private Random random;

	public ComputerPlayer(String name, char symbol) {
		super(name, symbol);
		random = new Random();
	}

	public void makeMove(Board board) {

		System.out.println("Computer is making a move...");

		int position;

		while (true) {
			position = random.nextInt(9) + 1;

			try {
				board.placeMove(position, symbol);
				break;
			} catch (Exception e) {
				
			}
		}
	}
}