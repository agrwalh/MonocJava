package com.project.model;

import java.util.Scanner;

public class InventoryApp {

	private InventoryService service;
	private Scanner sc;

	public InventoryApp(InventoryService service, Scanner sc) {
		this.service = service;
		this.sc = sc;
	}

	public void start() {

		while (true) {

			System.out.println("\n1. Add Product");
			System.out.println("2. Add Stock");
			System.out.println("3. Remove Stock");
			System.out.println("4. Delete Product");
			System.out.println("5. Show Products");
			System.out.println("6. Calculate Value");
			System.out.println("7. Exit");

			if (!sc.hasNextInt()) {
				System.out.println("Invalid input!");
				sc.next();
				continue;
			}

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				addProduct();
				break;
			case 2:
				addStock();
				break;
			case 3:
				removeStock();
				break;
			case 4:
				deleteProduct();
				break;
			case 5:
				service.showAllProducts();
				break;
			case 6:
				calculateValue();
				break;
			case 7:
				System.out.println("Exit");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private void addProduct() {

		sc.nextLine();

		System.out.print("Name: ");
		String name = sc.nextLine();

		if (name.trim().isEmpty()) {
			System.out.println("Invalid name!");
			return;
		}

		System.out.print("Qty: ");
		if (!sc.hasNextInt()) {
			System.out.println("Invalid quantity!");
			sc.next();
			return;
		}
		int qty = sc.nextInt();

		System.out.print("Reorder Level: ");
		int r = sc.nextInt();

		System.out.print("Price: ");
		double price = sc.nextDouble();

		service.addProduct(new Product(name, qty, r, price));
	}

	private void addStock() {

		sc.nextLine();

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Qty: ");
		int qty = sc.nextInt();

		service.addStock(name, qty);
	}

	private void removeStock() {

		sc.nextLine();

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Qty: ");
		int qty = sc.nextInt();

		System.out.print("Reorder Qty: ");
		int reorder = sc.nextInt();

		service.removeStock(name, qty, reorder);
	}

	private void deleteProduct() {

		sc.nextLine();

		System.out.print("Name: ");
		service.deleteProduct(sc.nextLine());
	}

	private void calculateValue() {

		sc.nextLine();

		System.out.print("Name: ");
		Product p = service.getProduct(sc.nextLine());

		if (p == null) {
			System.out.println("Not found!");
			return;
		}

		System.out.println("1.FIFO 2.LIFO");
		int v = sc.nextInt();

		ValuationStrategy strategy = (v == 1) ? new FIFOValuation() : new LIFOValuation();

		System.out.println("Value: $" + strategy.calculate(p.getQuantity(), p.getPrice()));
	}
}