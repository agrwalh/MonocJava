package com.project.model;

public class FIFOValuation implements ValuationStrategy {

	public double calculate(int quantity, double price) {
		return quantity * price;
	}
}