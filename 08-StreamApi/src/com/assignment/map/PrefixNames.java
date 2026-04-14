package com.assignment.map;

import java.util.*;


public class PrefixNames {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter names:");

		List<String> names = Arrays.asList(sc.nextLine().split(" "));

		names.stream().map(name -> "Mr./Ms. " + name).forEach(System.out::println);
	}
}