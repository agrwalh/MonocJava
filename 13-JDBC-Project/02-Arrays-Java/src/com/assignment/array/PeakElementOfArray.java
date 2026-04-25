package com.assignment.array;

import java.util.Scanner;

public class PeakElementOfArray {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        int size = scanner.nextInt();

        if(size <= 0){
            System.out.println("Array size must be greater than 0.");
            return;
        }

        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");

        for(int i = 0; i < size; i++){
            if(scanner.hasNextInt()){
                arr[i] = scanner.nextInt();
            } else{
                System.out.println("Invalid input. Enter integers only.");
                return;
            }
        }

        boolean peakFound = false;

        for(int i = 0; i < size; i++){

            if((i == 0 || arr[i] >= arr[i-1]) &&
               (i == size-1 || arr[i] >= arr[i+1])){

                System.out.println("Peak element found: " + arr[i]);
                peakFound = true;
                break;
            }
        }

        if(!peakFound){
            System.out.println("No peak element found.");
        }

        scanner.close();
    }
}