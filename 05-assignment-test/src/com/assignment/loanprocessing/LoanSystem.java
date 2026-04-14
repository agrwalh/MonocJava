package com.assignment.loanprocessing;
import java.util.Scanner;

public class LoanSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter number of loans: ");
            int n = scanner.nextInt();

            Loan[] loans = new Loan[n];

            for (int i = 0; i < n; i++) {

                System.out.println("\nChoose Loan Type");
                System.out.println("1. Home Loan");
                System.out.println("2. Car Loan");
                System.out.println("3. Education Loan");

                int type = scanner.nextInt();

                System.out.print("Enter Loan ID: ");
                int id = scanner.nextInt();

                scanner.nextLine(); 

                System.out.print("Enter Borrower Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Principal Amount: ");
                double amount = scanner.nextDouble();

                System.out.print("Enter Interest Rate: ");
                double rate = scanner.nextDouble();

                
                if (type == 1) {

                    loans[i] = new HomeLoan(id, name, amount, rate);

                } else if (type == 2) {

                    loans[i] = new CarLoan(id, name, amount, rate);

                } else if (type == 3) {

                    loans[i] = new EducationLoan(id, name, amount, rate);

                } else {

                    System.out.println("Invalid Loan Type");
                    i--; 
                }
            }


            for (Loan loan : loans) {

                loan.displayLoanDetails();

                LoanEligibility e = (LoanEligibility) loan;

                if (e.checkEligibility()) {

                    System.out.println("Loan Approved");
                    System.out.println("Total Repayment: " + loan.calculateRepayment());

                } else {

                    System.out.println("Loan Not Approved");
                }
            }

        } catch (InvalidLoanException e) {

            
            System.out.println("Invalid Loan Input: " + e.getMessage());

        }
        catch (java.util.InputMismatchException e) {

            
            System.out.println("Invalid Input Type! Please enter correct data.");

        }
        catch (Exception e) {

           
            System.out.println("Unexpected Error Occurred.");
        }

        scanner.close();
    }
}