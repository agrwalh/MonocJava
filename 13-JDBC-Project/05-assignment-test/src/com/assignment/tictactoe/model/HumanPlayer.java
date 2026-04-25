package com.assignment.tictactoe.model;

import java.util.Scanner;

import com.assignment.tictactoe.excptions.InvalidMoveException;
import com.assignment.tictactoe.excptions.PositionOccupiedException;

public class HumanPlayer extends Player {

	private Scanner scanner;

	public HumanPlayer(String name, char symbol, Scanner scanner) {
		super(name, symbol);
		this.scanner = scanner;
	}

	public void makeMove(Board board) {

		int position;

		while (true) {

			System.out.println(name + "'s Turn (" + symbol + ")");
			System.out.print("Choose position (1-9): ");

			if (!scanner.hasNextInt()) {
				System.out.println("Enter numbers only!");
				scanner.next();
				continue;
			}

			position = scanner.nextInt();

			try {
				board.placeMove(position, symbol);
				break;
			} catch (InvalidMoveException | PositionOccupiedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}