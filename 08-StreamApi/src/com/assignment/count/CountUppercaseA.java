package com.assignment.count;

import java.util.*;
//import java.util.stream.*;

public class CountUppercaseA {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter names:");

		List<String> names = Arrays.asList(sc.nextLine().split(" "));

		System.out.println("Names starting with A:");

		long count=names.stream().filter(name -> name.startsWith("A")).count();
		System.out.println(count);
		sc.close();
	}
}