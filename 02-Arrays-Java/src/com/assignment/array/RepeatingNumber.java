package com.assignment.array;

import java.util.Scanner;

public class RepeatingNumber {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of array:");
		int sizeofarray = scanner.nextInt();

		if (sizeofarray <= 0) {
			System.out.println("Array size must be greater than 0");
			return;
		}

		int[] arr = new int[sizeofarray];

		System.out.println("Enter " + sizeofarray + " elements:");

		for (int i = 0; i < sizeofarray; i++) {
			if (scanner.hasNextInt()) {
				arr[i] = scanner.nextInt();
			} else {
				System.out.println("Invalid input. Enter integers only.");
				return;
			}
		}

		System.out.println("Enter number to find frequency:");
		int target = scanner.nextInt();

		int count = 0;

		for (int num : arr) {
			if (num == target) {
				count++;
			}
		}

		System.out.println("Number " + target + " appears " + count + " times.");

		scanner.close();
	}
}