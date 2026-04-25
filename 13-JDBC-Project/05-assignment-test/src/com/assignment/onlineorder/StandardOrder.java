package com.assignment.onlineorder;

public class StandardOrder extends Order {

	public StandardOrder(int id, String name, double amount) throws InvalidOrderException {
		super(id, name, amount);
		System.out.println("Standard Order created");
	}

	@Override
	public double processOrder() {

		double shipping = 50;
		return orderAmount + shipping;
	}

	@Override
	public boolean verifyOrder() {

		return orderAmount >= 100;
	}
}