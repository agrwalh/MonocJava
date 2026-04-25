package com.project.model;

public class LIFOValuation implements ValuationStrategy {

	public double calculate(int quantity, double price) {
		return quantity * price;
	}
}