package com.assignment.onlineorder;

public class ExpressOrder extends Order {

	private double expressCharge;

	public ExpressOrder(int id, String name, double amount, double expressCharge) throws InvalidOrderException {

		super(id, name, amount);

		if (expressCharge < 0)
			throw new InvalidOrderException("Invalid express charge");

		this.expressCharge = expressCharge;

		System.out.println("Express Order created");
	}

	@Override
	public double processOrder() {

		return orderAmount + expressCharge;
	}

	@Override
	public boolean verifyOrder() {

		return orderAmount > 200;
	}
}
