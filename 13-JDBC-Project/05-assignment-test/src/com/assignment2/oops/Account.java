package com.assignment2.oops;

public class Account {
	private int accountNumber;
	private String holderName;
	private double balance;

	public Account(int accountNumber, String holderName, double balance) {

		
		if (balance < 0) {
			System.out.println("Invalid balance");
			return;
		}

		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void displayAccountInfo() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Holder Name: " + holderName);
		System.out.println("Balance: " + balance);
	}
}
