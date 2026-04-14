package com.project.model;

public class Product {

	private String name;
	private int quantity;
	private int reorderLevel;
	private double price;

	public Product(String name, int quantity, int reorderLevel, double price) {

		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid name");
		}

		if (quantity < 0 || reorderLevel < 0 || price <= 0) {
			throw new IllegalArgumentException("Invalid values");
		}

		this.name = name.toLowerCase();
		this.quantity = quantity;
		this.reorderLevel = reorderLevel;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public double getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0)
			throw new IllegalArgumentException("Invalid quantity");
		this.quantity = quantity;
	}
}