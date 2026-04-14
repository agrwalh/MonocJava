package com.assignment.comparatorcomparable;

import java.util.*;

class Product {
	String category;
	String name;
	double price;

	Product(String category, String name, double price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return category + " | " + name + " | " + price;
	}
}

public class SortProducts {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Product> list = new ArrayList<>();

		System.out.print("Enter number of products: ");
		if (!scanner.hasNextInt()) {
			System.out.println("Invalid input! Please enter a numeric value.");
			return;
		}
		int n = scanner.nextInt();
		if (n <= 0) {
			System.out.println("Number of products must be greater than zero.");
		}
		scanner.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("\nEnter details for product " + (i + 1));

			System.out.print("Enter category: ");
			String category = scanner.nextLine();

			if (category.trim().isEmpty()) {
				System.out.println("Invalid category!");
				i--;
				continue;
			}
			 if (!category.matches("[a-zA-Z ]+")) {
	                System.out.println("Category must contain only letters!");
	                i--;
	                continue;
	            }

			System.out.print("Enter product name: ");
			String name = scanner.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("Invalid product name!");
				i--;
				continue;
			}

			System.out.print("Enter price: ");
			double price = scanner.nextDouble();
			scanner.nextLine();

			if (price <= 0) {
				System.out.println("Price must be greater than 0");
				i--;
				continue;
			}

			list.add(new Product(category, name, price));
		}

		Collections.sort(list, new Comparator<Product>() {

			public int compare(Product p1, Product p2) {

				int categoryCompare = p1.category.compareToIgnoreCase(p2.category);

				if (categoryCompare == 0) {
					return Double.compare(p1.price, p2.price);
				}

				return categoryCompare;
			}
		});

		System.out.println("\nSorted Product List:");

		for (Product p : list) {
			System.out.println(p);
		}

		scanner.close();
	}
}
