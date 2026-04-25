package com.assignment.array;

import java.util.Scanner;

public class SubstingInString {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter main string:");
		String mainStr = scanner.nextLine();

		System.out.println("Enter substring:");
		String subStr = scanner.nextLine();

		if (mainStr.length() == 0 || subStr.length() == 0) {
			System.out.println("Strings cannot be empty.");
			return;
		}

		char[] mainArr = mainStr.toCharArray();
		char[] subArr = subStr.toCharArray();

		int n = mainArr.length;
		int m = subArr.length;

		boolean found = false;

		for (int i = 0; i <= n - m; i++) {

			int j;

			for (j = 0; j < m; j++) {
				if (mainArr[i + j] != subArr[j]) {
					break;
				}
			}

			if (j == m) {
				System.out.println("Substring found at index: " + i);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Substring not found.");
		}

		scanner.close();
	}
}
