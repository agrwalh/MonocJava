package com.assignment.model;

public class BankAccount {

	private double balance;

	public BankAccount(double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("Invalid initial balance");
		}
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Invalid deposit");
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Invalid withdraw");
		}
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient balance");
		}
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}
