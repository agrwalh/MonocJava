package com.assignment1.ecommerce;
public class PricingService {

	public double calculatePrice(Product product, double discountPercent, double taxPercent) {

		double basePrice = product.getPrice();

		double discount = basePrice * discountPercent / 100;
		double tax = basePrice * taxPercent / 100;

		return basePrice - discount + tax;
	}
}