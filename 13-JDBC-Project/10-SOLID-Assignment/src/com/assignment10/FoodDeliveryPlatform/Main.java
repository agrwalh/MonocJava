package com.assignment10.FoodDeliveryPlatform;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter role (customer/owner): ");
		String role = sc.nextLine();

		if (role.equalsIgnoreCase("customer")) {

			CustomerOps customer = new Customer();

			System.out.println("1. Place Order");
			System.out.println("2. Track Order");
			System.out.println("3. Rate Driver");
			System.out.print("Choose option: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				customer.placeOrder();
				break;
			case 2:
				customer.trackOrder();
				break;
			case 3:
				customer.rateDriver();
				break;
			default:
				System.out.println("Invalid choice");
			}

		} else if (role.equalsIgnoreCase("owner")) {

			RestaurantOps owner = new RestaurantOwner();

			System.out.println("1. Manage Restaurant");
			System.out.print("Choose option: ");

			int choice = sc.nextInt();

			if (choice == 1) {
				owner.manageRestaurant();
			} else {
				System.out.println("Invalid choice");
			}

		} else {
			System.out.println("Invalid role");
		}

		sc.close();
	}
}
