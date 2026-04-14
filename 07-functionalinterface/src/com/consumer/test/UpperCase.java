package com.consumer.test;

import java.util.Scanner;
import java.util.function.Consumer;

public class UpperCase {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Consumer<String> upper = s -> System.out.println(s.toUpperCase());

		System.out.println("Enter a string:");
		String input = scanner.nextLine();

		upper.accept(input);

		scanner.close();
	}
}