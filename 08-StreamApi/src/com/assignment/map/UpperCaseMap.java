package com.assignment.map;

import java.util.*;

public class UpperCaseMap {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter strings:");

		List<String> list = Arrays.asList(scanner.nextLine().split(" "));

		list.stream().map(String::toUpperCase).forEach(System.out::println);
		scanner.close();
	}
}
