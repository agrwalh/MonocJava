package com.project.model;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

	private Notifier[] notifiers;
	private ReorderService reorderService;

	private Map<String, Product> productMap = new HashMap<>();

	public InventoryService(Notifier[] notifiers, ReorderService reorderService) {
		this.notifiers = notifiers;
		this.reorderService = reorderService;
	}

	public void addProduct(Product product) {

		String name = product.getName();

		if (productMap.containsKey(name)) {

			Product existing = productMap.get(name);
			existing.setQuantity(existing.getQuantity() + product.getQuantity());

			System.out.println("Product exists. Quantity updated: " + existing.getQuantity());

		} else {
			productMap.put(name, product);
			System.out.println("Product added: " + name);
		}
	}

	public void addStock(String name, int qty) {

		Product product = productMap.get(name.toLowerCase());

		if (product == null) {
			System.out.println("Product not found!");
			return;
		}

		product.setQuantity(product.getQuantity() + qty);

		System.out.println("Stock added. New quantity: " + product.getQuantity());
	}

	public void removeStock(String name, int qty, int reorderQty) {

		Product product = productMap.get(name.toLowerCase());

		if (product == null) {
			System.out.println("Product not found!");
			return;
		}

		if (qty > product.getQuantity()) {
			System.out.println("Not enough stock!");
			return;
		}

		product.setQuantity(product.getQuantity() - qty);

		System.out.println("Removed " + qty + " units of '" + name + "'");
		System.out.println("Current stock: " + product.getQuantity());

		if (product.getQuantity() < product.getReorderLevel()) {

			System.out.println("Reorder triggered!");

			reorderService.reorder(product, reorderQty);

			for (Notifier notifier : notifiers) {
				notifier.sendNotification(product);
			}
		}
	}

	public void deleteProduct(String name) {

		if (productMap.remove(name.toLowerCase()) != null) {
			System.out.println("Product deleted.");
		} else {
			System.out.println("Product not found.");
		}
	}

	public void showAllProducts() {

		if (productMap.isEmpty()) {
			System.out.println("No products.");
			return;
		}

		for (Product p : productMap.values()) {

			System.out.println("Name: " + p.getName() + ", Qty: " + p.getQuantity() + ", Price: " + p.getPrice()
					+ ", Reorder: " + p.getReorderLevel());
		}
	}

	public Product getProduct(String name) {
		return productMap.get(name.toLowerCase());
	}
}