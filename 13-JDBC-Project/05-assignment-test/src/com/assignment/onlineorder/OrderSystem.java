package com.assignment.onlineorder;



import java.util.Scanner;

public class OrderSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Order[] orders = new Order[3];

		int count = 0;

		while (count < orders.length) {

			try {

				System.out.println("\nSelect Order Type");
				System.out.println("1. Standard Order");
				System.out.println("2. Express Order");
				System.out.println("3. International Order");

				int choice = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Order ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Customer Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Order Amount: ");
				double amount = sc.nextDouble();

				switch (choice) {

				case 1:

					orders[count] = new StandardOrder(id, name, amount);
					break;

				case 2:

					System.out.print("Enter Express Charge: ");
					double express = sc.nextDouble();

					orders[count] = new ExpressOrder(id, name, amount, express);
					break;

				case 3:

					System.out.print("Enter Customs Duty: ");
					double duty = sc.nextDouble();

					orders[count] = new InternationalOrder(id, name, amount, duty);
					break;

				default:

					System.out.println("Invalid order type");
					continue;
				}

				count++;

			} catch (InvalidOrderException e) {

				System.out.println("Invalid Order: " + e.getMessage());

			} catch (Exception e) {

				System.out.println("Invalid input type");
				sc.nextLine();
			}
		}

		System.out.println("\n----- Processing Orders -----");

		for (Order order : orders) {

			order.displayOrder();

			if (order.verifyOrder()) {

				System.out.println("Order Verified Successfully");
				System.out.println("Final Amount: " + order.processOrder());

			} else {

				System.out.println("Order verification failed");
			}

			System.out.println("----------------------------");
		}

		sc.close();
	}
}
