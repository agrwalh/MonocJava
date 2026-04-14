package com.assignment.count;

import java.util.List;

public class CountEven {
	public static void main(String[] args) {

		List<Integer> list = List.of(10, 15, 20, 25);

		long count = list.stream().filter(n -> n % 2 == 0).count();

		System.out.println(count);
	}
}