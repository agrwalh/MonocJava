package com.assignment.filter;

import java.util.*;
import java.util.stream.*;

public class EvenFilter {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numbers (space separated):");

		List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toList());

		System.out.println("Even numbers:");

		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
	}
}
