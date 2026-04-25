package com.assignment.sorted;

import java.util.List;

public class SortNumbers {
	public static void main(String args[]) {
		List<Integer> list = List.of(4, 3, 6, 88, 1, 0);
		list.stream().sorted().forEach(System.out::println);

	}

}
