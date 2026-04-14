package com.assignment.array;

import java.util.Scanner;

public class SecondMaxOfArray {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of array:");
		int sizeofarray = scanner.nextInt();

		if (sizeofarray < 2) {
			System.out.println("Second maximum requires at least 2 elements.");
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

		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int num : arr) {

			if (num > max) {
				secondMax = max;
				max = num;
			} else if (num > secondMax && num != max) {
				secondMax = num;
			}
		}

		if (secondMax == Integer.MIN_VALUE) {
			System.out.println("Second maximum does not exist.");
		} else {
			System.out.println("Second maximum element is: " + secondMax);
		}

		scanner.close();
	}
}