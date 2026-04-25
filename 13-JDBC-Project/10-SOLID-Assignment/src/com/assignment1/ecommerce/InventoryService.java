package com.assignment1.ecommerce;

public class InventoryService {

	public void addStock(Product product, int quantity) {
		product.setStock(product.getStock() + quantity);
	}

	public void removeStock(Product product, int quantity) {
		if (product.getStock() >= quantity) {
			product.setStock(product.getStock() - quantity);
		} else {
			System.out.println("Insufficient stock!");
		}
	}

	public boolean isAvailable(Product product) {
		return product.getStock() > 0;
	}
}
