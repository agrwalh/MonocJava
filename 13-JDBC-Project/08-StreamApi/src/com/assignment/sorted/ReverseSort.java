package com.assignment.sorted;

import java.util.List;
import java.util.Comparator;

public class ReverseSort {
	public static void main(String[] args) {

		List<String> list = List.of("Banana", "Apple", "Mango");

		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}