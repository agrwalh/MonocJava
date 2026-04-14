package com.assignment.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

import com.assignment.tictactoe.excptions.InvalidMoveException;
import com.assignment.tictactoe.excptions.PositionOccupiedException;

public class Board {

    private char[] board;
    private List<String> moves;

    public Board() {
        board = new char[9];
        moves = new ArrayList<>();
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);
        }
        moves.clear();
    }

    public void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public void placeMove(int position, char symbol)
            throws InvalidMoveException, PositionOccupiedException {

        if (position < 1 || position > 9) {
            throw new InvalidMoveException("Position must be between 1 and 9");
        }

        if (board[position - 1] == 'X' || board[position - 1] == 'O') {
            throw new PositionOccupiedException("Cell already occupied!");
        }

        board[position - 1] = symbol;
        moves.add(symbol + " -> " + position);
    }

    public void printMoves() {
        System.out.println("\nMove History:");
        for (String move : moves) {
            System.out.println(move);
        }
    }

    public boolean checkWin(char s) {
        int[][] winPatterns = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };

        for (int[] p : winPatterns) {
            if (board[p[0]] == s && board[p[1]] == s && board[p[2]] == s)
                return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O')
                return false;
        }
        return true;
    }
}