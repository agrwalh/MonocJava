package com.assignment.tictactoe.excptions;

public class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message);
    }
}