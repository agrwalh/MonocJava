package com.assignment.comparatorcomparable;

import java.util.*;

class Transaction {
	int id;
	double amount;

	Transaction(int id, double amount) {
		this.id = id;
		this.amount = amount;
	}


	public String toString() {
		return "ID: " + id + " | Amount: " + amount;
	}
}

public class SortTransactions {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Transaction> list = new ArrayList<>();

		System.out.print("Enter number of transactions: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("\nEnter details for transaction " + (i + 1));

			System.out.print("Enter transaction ID: ");

			if (!sc.hasNextInt()) {
				System.out.println("ID must be an integer!");
				sc.next();
				i--;
				continue;
			}

			int id = sc.nextInt();

			if (id <= 0) {
				System.out.println("ID must be positive!");
				i--;
				continue;
			}

			System.out.print("Enter amount: ");

			if (!sc.hasNextDouble()) {
				System.out.println("Amount must be numeric!");
				sc.next();
				i--;
				continue;
			}

			double amount = sc.nextDouble();

			if (amount <= 0) {
				System.out.println("Amount must be greater than 0!");
				i--;
				continue;
			}

			list.add(new Transaction(id, amount));
		}

		Collections.sort(list, new Comparator<Transaction>() {

			public int compare(Transaction t1, Transaction t2) {

				int amountCompare = Double.compare(t2.amount, t1.amount);

				if (amountCompare == 0) {
					return t1.id - t2.id;
				}

				return amountCompare;
			}
		});

		System.out.println("\nSorted Transactions:");

		for (Transaction t : list) {
			System.out.println(t);
		}

		sc.close();
	}
}
