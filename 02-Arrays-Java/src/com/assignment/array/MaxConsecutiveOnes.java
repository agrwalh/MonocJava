package com.assignment.array;

import java.util.Scanner;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of array:");
		int size = scanner.nextInt();

		if (size <= 0) {
			System.out.println("Array size must be greater than 0.");
			return;
		}

		int[] arr = new int[size];

		System.out.println("Enter " + size + " elements (only 0 or 1):");

		for (int i = 0; i < size; i++) {

			if (scanner.hasNextInt()) {
				arr[i] = scanner.nextInt();

				if (arr[i] != 0 && arr[i] != 1) {
					System.out.println("Invalid input. Only 0 or 1 allowed.");
					return;
				}

			} else {
				System.out.println("Invalid input.");
				return;
			}
		}

		int maxCount = 0;
		int currentCount = 0;

		for (int num : arr) {

			if (num == 1) {
				currentCount++;
				maxCount = Math.max(maxCount, currentCount);
			} else {
				currentCount = 0;
			}
		}

		System.out.println("Maximum consecutive 1s: " + maxCount);

		scanner.close();
	}
}