package com.assignment.tictactoe.model;

public class Game {

    private Player p1, p2, current;
    private Board board;

    public Game(Player p1, Player p2, Board board) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.current = p1;
    }

    public Player getCurrent() {
        return current;
    }

    public Board getBoard() {
        return board;
    }

    public void playTurn() {
        current.makeMove(board);
    }

    public boolean isWin() {
        return board.checkWin(current.getSymbol());
    }

    public boolean isDraw() {
        return board.isFull();
    }

    public void switchPlayer() {
        current = (current == p1) ? p2 : p1;
    }
}