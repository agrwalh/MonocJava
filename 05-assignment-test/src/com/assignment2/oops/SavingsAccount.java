package com.assignment2.oops;

class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accountNumber, String holderName, double balance, double interestRate){

        super(accountNumber, holderName, balance); // constructor chaining
        this.interestRate = interestRate;
    }

    public void displayAccountInfo(){

        super.displayAccountInfo();

        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Account Type: Savings Account");
        System.out.println();
    }
}
