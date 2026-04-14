package com.assignment.filter;

import java.util.*;

class Product {
	String name;
	int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

public class ProductFilter {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();

		System.out.println("Enter number of products:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter product name and price:");
			String name = sc.next();
			int price = sc.nextInt();

			list.add(new Product(name, price));
		}

		System.out.println("Products with price > 500:");

		list.stream().filter(p -> p.price > 500).forEach(p -> System.out.println(p.name +" "+ p.price));
	}
}