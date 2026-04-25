package com.assignment.count;

import java.util.List;

public class DiscountCount {
	public static void main(String[] args) {

		List<Integer> prices = List.of(1000, 800, 400, 300);

		long count = prices.stream().map(p -> p * 0.8).filter(p -> p > 500).count();

		System.out.println("Products > 500 after discount: " + count);
	}
}