package com.supplier.test;

import java.util.function.Supplier;

public class RandomNumber {
	public static void main(String[] args) {

		Supplier<Double> random = () -> Math.random();

		for (int i = 0; i < 5; i++) {
			System.out.println(random.get());
		}
	}
}
