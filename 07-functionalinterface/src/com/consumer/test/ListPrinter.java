package com.consumer.test;

import java.util.*;
import java.util.function.Consumer;

public class ListPrinter {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();

		System.out.print("Enter number of elements: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.print("Enter element: ");
			String s = sc.nextLine();
			list.add(s);
		}

		Consumer<List<String>> printer = l -> {
			for (String item : l) {
				System.out.println(item);
			}
		};

		System.out.println("\nList Elements:");
		printer.accept(list);

		sc.close();
	}
}
