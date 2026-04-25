package com.functionalinterface.poc;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Java", "Spring", "Angular");

//		names.forEach(System.out::println);
		names.forEach(item -> System.out.println(item));
	}
}
