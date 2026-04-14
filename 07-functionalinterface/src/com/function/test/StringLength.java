package com.function.test;

import java.util.Scanner;
import java.util.function.Function;

public class StringLength {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Function<String, Integer> len = s -> s.length();

		System.out.println("Enter 3 names:");

		for (int i = 1; i <= 3; i++) {
			System.out.print("Enter name " + i + ": ");
			String name = scanner.nextLine();

			int length = len.apply(name);

			System.out.println("Length of " + name + " is: " + length);
		}

		scanner.close();
	}
}