package com.assignment7.BankingSystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter account type (savings/fd): ");
		String type = sc.nextLine();

		System.out.print("Enter amount to deposit: ");
		double amount = sc.nextDouble();

		DepositAccount account = null;


		if (type.equalsIgnoreCase("savings")) {
			account = new SavingsAccount();
		} else if (type.equalsIgnoreCase("fd")) {
			account = new FixedDepositAccount();
		} else {
			System.out.println("Invalid account type");
			return;
		}


		account.deposit(amount);


		if (account instanceof Withdrawable) {
			System.out.print("Enter amount to withdraw: ");
			double withdrawAmount = sc.nextDouble();

			Withdrawable w = (Withdrawable) account;
			w.withdraw(withdrawAmount);
		} else {
			System.out.println("Withdraw not allowed for this account type.");
		}

		sc.close();
	}
}
