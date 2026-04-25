package com.assignment.array;

import java.util.Scanner;

public class AddMulTranspose {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter rows:");
		int r = sc.nextInt();

		System.out.println("Enter columns:");
		int c = sc.nextInt();

		if (r <= 0 || c <= 0) {
			System.out.println("Rows and columns must be greater than 0.");
			return;
		}

		int[][] A = new int[r][c];
		int[][] B = new int[r][c];

		System.out.println("Enter elements of Matrix A:");

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		System.out.println("Enter elements of Matrix B:");

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				B[i][j] = sc.nextInt();
			}
		}

		while (true) {

			System.out.println("\nMENU");
			System.out.println("1. Addition");
			System.out.println("2. Multiplication");
			System.out.println("3. Transpose of Matrix A");
			System.out.println("4. Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				int[][] sum = new int[r][c];

				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						sum[i][j] = A[i][j] + B[i][j];
					}
				}

				System.out.println("Addition Result:");

				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						System.out.print(sum[i][j] + " ");
					}
					System.out.println();
				}
				break;

			case 2:

				int[][] mul = new int[r][c];

				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						for (int k = 0; k < c; k++) {
							mul[i][j] += A[i][k] * B[k][j];
						}
					}
				}

				System.out.println("Multiplication Result:");

				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						System.out.print(mul[i][j] + " ");
					}
					System.out.println();
				}

				break;

			case 3:

				System.out.println("Transpose of Matrix A:");

				for (int i = 0; i < c; i++) {
					for (int j = 0; j < r; j++) {
						System.out.print(A[j][i] + " ");
					}
					System.out.println();
				}

				break;

			case 4:
				System.out.println("Exiting...");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
