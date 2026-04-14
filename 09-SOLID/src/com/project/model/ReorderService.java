package com.project.model;

public class ReorderService {

	public void reorder(Product product, int qty) {

		if (qty <= 0) {
			System.out.println("Invalid reorder quantity!");
			return;
		}

		System.out.println("Reorder placed for " + qty + " units of '" + product.getName() + "'");
	}
}