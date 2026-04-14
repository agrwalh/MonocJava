package com.assignment7.BankingSystem;

class FixedDepositAccount implements DepositAccount {

	public void deposit(double amount) {
		System.out.println("Deposited in FD: " + amount);
	}

}
