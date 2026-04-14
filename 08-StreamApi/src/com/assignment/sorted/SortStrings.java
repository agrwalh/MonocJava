package com.assignment.sorted;

import java.util.List;

public class SortStrings {
	public static void main(String[] args) {

		List<String> list = List.of("Banana", "Apple", "Mango");

		list.stream().sorted().forEach(System.out::println);
	}
}
