package com.assignment.array;

import java.util.Scanner;

public class FindingMaximumOfArray {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int sizeofarray=scanner.nextInt();
		int[] arr = new int[sizeofarray];
		System.out.println("Enter " + sizeofarray + " elements:");
		for(int i = 0; i < sizeofarray; i++){
            if(scanner.hasNextInt()){
                arr[i] = scanner.nextInt();
            }
            } 
          int maximumofarray=Integer.MIN_VALUE;
        for(int i=0;i<sizeofarray;i++) {
        	if(arr[i]>maximumofarray) {
        		maximumofarray=arr[i];
        	}
        	
        }
        System.out.println("The maximum of the array is "+maximumofarray);
		scanner.close();
		
	}

}

