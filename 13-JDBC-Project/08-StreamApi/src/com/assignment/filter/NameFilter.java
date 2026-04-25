package com.assignment.filter;

import java.util.*;
//import java.util.stream.*;

public class NameFilter {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter names:");

		List<String> names = Arrays.asList(sc.nextLine().split(" "));

		System.out.println("Names starting with A:");

		names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
		sc.close();
	}
}