package com.assignment1.ecommerce;

public class ProductRenderer {

	public void display(Product product, double finalPrice) {
		System.out.println("Product: " + product.getName());
		System.out.println("Price: " + finalPrice);
		System.out.println("Stock: " + product.getStock());
	}
}
