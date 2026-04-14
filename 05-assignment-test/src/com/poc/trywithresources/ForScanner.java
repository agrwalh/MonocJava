package com.poc.trywithresources;

import java.util.Scanner;

public class ForScanner {
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter number:");
            int n = sc.nextInt();
            System.out.println("Number = " + n);

        }
    }
}
