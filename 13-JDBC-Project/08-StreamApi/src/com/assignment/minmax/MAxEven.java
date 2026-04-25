package com.assignment.minmax;

import java.util.List;

public class MAxEven {
	public static void main(String[] args) {

		List<Integer> list = List.of(5, 2, 8, 3, 10, 7);

		int maxEven = list.stream().filter(n -> n % 2 == 0).max((a, b) -> a - b).get();

		System.out.println("Max Even: " + maxEven);
	}
}