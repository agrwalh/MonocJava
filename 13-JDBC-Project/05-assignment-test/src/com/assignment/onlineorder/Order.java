package com.assignment.onlineorder;

public abstract class Order implements OrderVerification {

	protected int orderId;
	protected String customerName;
	protected double orderAmount;

	static {
		System.out.println("Order Fulfillment System Initialized...");
	}

	public Order(int orderId, String customerName, double orderAmount) throws InvalidOrderException {

		if (orderId <= 0)
			throw new InvalidOrderException("Order ID must be positive");

		if (customerName == null || customerName.trim().isEmpty())
			throw new InvalidOrderException("Customer name cannot be empty");

		if (orderAmount < 0)
			throw new InvalidOrderException("Order amount cannot be negative");

		this.orderId = orderId;
		this.customerName = customerName;
		this.orderAmount = orderAmount;

		System.out.println("Order constructor executed");
	}

	public abstract double processOrder();

	public void displayOrder() {

		System.out.println("Order ID: " + orderId);
		System.out.println("Customer Name: " + customerName);
		System.out.println("Order Amount: " + orderAmount);
	}
}
