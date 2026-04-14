package com.assignment2.oops;

class CurrentAccount extends Account {

	private double overdraftLimit;

	public CurrentAccount(int accountNumber, String holderName, double balance, double overdraftLimit) {

		super(accountNumber, holderName, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public void displayAccountInfo() {

		super.displayAccountInfo();

		System.out.println("Overdraft Limit: " + overdraftLimit);
		System.out.println("Account Type: Current Account");
		System.out.println();
	}
}
