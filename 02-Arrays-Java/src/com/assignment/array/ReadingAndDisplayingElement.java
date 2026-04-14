package com.assignment.array;

import java.util.Scanner;

public class ReadingAndDisplayingElement {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int sizeofarray = scanner.nextInt();
		int[] arr = new int[sizeofarray];
		System.out.println("Enter " + sizeofarray + " elements:");
		for(int i = 0; i < sizeofarray; i++){
            if(scanner.hasNextInt()){
                arr[i] = scanner.nextInt();
            } 
            else{
                System.out.println("Invalid input. Please enter integers only.");
                return;
            }
        }
		for (int i = 0; i < sizeofarray; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println("Array elements are:");
		for (int i = 0; i < sizeofarray; i++) {
			System.out.print(arr[i] + " ");
		}
		scanner.close();

	}

}
