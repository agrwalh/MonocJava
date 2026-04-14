package com.assignment2.oops;

import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    
        Account[] accounts = new Account[3];

        for (int i = 0; i < accounts.length; i++) {

            System.out.println("Enter Account Type:");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");

            int type = sc.nextInt();
            sc.nextLine(); 

          
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Balance: ");
            double balance = sc.nextDouble();

            switch (type) {

                case 1:
                    System.out.print("Enter Interest Rate: ");
                    double rate = sc.nextDouble();

                    
                    accounts[i] = new SavingsAccount(accNo, name, balance, rate);
                    break;

                case 2:
                    System.out.print("Enter Overdraft Limit: ");
                    double limit = sc.nextDouble();

              
                    accounts[i] = new CurrentAccount(accNo, name, balance, limit);
                    break;

                default:
                    System.out.println("Invalid account type. Try again.");
                    i--;
            }
        }

    
        System.out.println("\n--- Account Details ---");

        for (Account acc : accounts) {
            acc.displayAccountInfo();
        }

        sc.close();
    }
}