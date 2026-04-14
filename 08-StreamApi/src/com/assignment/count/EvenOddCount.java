package com.assignment.count;

import java.util.List;

public class EvenOddCount {
	public static void main(String args[]) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		long even = list.stream().filter(n -> n % 2 == 0).count();
		long odd = list.stream().filter(n -> n % 2 != 0).count();
		System.out.println("Even: " + even);
		System.out.println("Odd: " + odd);

	}

}
