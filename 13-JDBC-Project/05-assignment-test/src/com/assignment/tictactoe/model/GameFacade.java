package com.assignment.tictactoe.model;

import java.util.Scanner;

public class GameFacade {

	private Scanner sc = new Scanner(System.in);

	public void launch() {

		while (true) {

			System.out.println("\n===== TIC TAC TOE =====");
			System.out.println("1. Start Game");
			System.out.println("2. Exit");
			System.out.print("Enter choice: ");

			if (!sc.hasNextInt()) {
				System.out.println("Numbers only!");
				sc.next();
				continue;
			}

			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1)
				startGame();
			else if (choice == 2) {
				System.out.println("Goodbye!");
				return;
			} else {
				System.out.println("Invalid choice!");
			}
		}
	}

	private void startGame() {

		Board board = new Board();
		Player p1, p2;

		int mode;

		while (true) {
			System.out.println("1. Human vs Human");
			System.out.println("2. Human vs Computer");

			if (!sc.hasNextInt()) {
				System.out.println("Enter Number only 1 and 2!");
				sc.next();
				continue;
			}

			mode = sc.nextInt();
			sc.nextLine();

			if (mode == 1 || mode == 2)
				break;
			else
				System.out.println("Invalid choice!");
		}

		if (mode == 1) {
			System.out.print("P1 name: ");
			p1 = new HumanPlayer(sc.nextLine(), 'X', sc);

			System.out.print("P2 name: ");
			p2 = new HumanPlayer(sc.nextLine(), 'O', sc);
		} else {
			System.out.print("Your name: ");
			p1 = new HumanPlayer(sc.nextLine(), 'X', sc);
			p2 = new ComputerPlayer("Computer", 'O');
		}

		Game game = new Game(p1, p2, board);

		while (true) {

			board.printBoard();
			game.playTurn();

			if (game.isWin()) {
				board.printBoard();
				System.out.println(game.getCurrent().getName() + " wins!");
				board.printMoves();
				break;
			}

			if (game.isDraw()) {
				board.printBoard();
				System.out.println("Draw!");
				board.printMoves();
				break;
			}

			game.switchPlayer();
		}

		replay();
	}

	private void replay() {

		while (true) {
			System.out.print("Play again? (y/n): ");
			String ch = sc.next();

			if (ch.equalsIgnoreCase("y"))
				return;
			else if (ch.equalsIgnoreCase("n")) {
				System.out.println("Exiting...");
				System.exit(0);
			} else {
				System.out.println("Invalid input!");
			}
		}
	}
}