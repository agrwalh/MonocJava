package com.assignment.map;

import java.util.List;

public class MultiplyBy10 {
	public static void main(String args[]) {
		List<Integer> list = List.of(1, 5, 7, 10);
		list.stream().map(n -> n * 10).forEach(System.out::println);
	}

}
