package com.function.test;

import java.util.function.Function;

public class Temperature {
	public static void main(String[] args) {

		Function<Double, Double> convert = c -> (c * 9 / 5) + 32;

		System.out.println(convert.apply(0.0));
		System.out.println(convert.apply(20.0));
		System.out.println(convert.apply(37.0));
	}
}
