package com.assignment.onlineorder;

public class InternationalOrder extends Order {

	private double customsDuty;

	public InternationalOrder(int id, String name, double amount, double customsDuty) throws InvalidOrderException {

		super(id, name, amount);

		if (customsDuty < 0)
			throw new InvalidOrderException("Invalid customs duty");

		this.customsDuty = customsDuty;

		System.out.println("International Order created");
	}

	@Override
	public double processOrder() {

		return orderAmount + customsDuty;
	}

	@Override
	public boolean verifyOrder() {

		return orderAmount >= 500;
	}
}
