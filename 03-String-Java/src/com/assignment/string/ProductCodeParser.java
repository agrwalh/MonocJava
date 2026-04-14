package com.assignment.string;

import java.util.Scanner;

public class ProductCodeParser {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter product code: ");
		String code = sc.nextLine().trim();

		if (!code.contains("-")) {
			System.out.println("Invalid product code format.");
			return;
		}

		String[] parts = code.split("-");

		if (parts.length != 3) {
			System.out.println("Invalid product code format.");
			return;
		}

		String category = parts[0];
		String product = parts[1];
		String year = parts[2];

		category = category.toUpperCase();

		boolean startsWithTV = product.startsWith("TV");
		boolean endsWith2023 = code.endsWith("2023");

		String modifiedCode = code.replace("-", " ");

		int firstHyphenPos = code.indexOf("-");

		// Output
		System.out.println("Category: " + category);
		System.out.println("Product: " + product);
		System.out.println("Year: " + year);
		System.out.println("Starts with TV: " + (startsWithTV ? "Yes" : "No"));
		System.out.println("Ends with 2023: " + (endsWith2023 ? "Yes" : "No"));
		System.out.println("Modified Code: " + modifiedCode);
		System.out.println("First hyphen position: " + firstHyphenPos);

		sc.close();
	}
}
