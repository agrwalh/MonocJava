package com.assignment.array;

import java.util.Scanner;

public class SumOfElementsOfArray {
	public static void main(String args[]) {
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
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		System.out.println("The sum of elements is " + sum);
	}
}
