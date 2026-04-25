package com.assignment.loanprocessing;

class CarLoan extends Loan implements LoanEligibility {

	public CarLoan(int loanId, String borrowerName, double principalAmount, double interestRate)
			throws InvalidLoanException {

		super(loanId, borrowerName, principalAmount, interestRate);
		System.out.println("CarLoan constructor executed");
	}

	@Override
	public double calculateRepayment() {

		double interest = principalAmount * interestRate * 5 / 100;
		return principalAmount + interest;
	}

	@Override
	public boolean checkEligibility() {

		return principalAmount <= 2000000; 
	}
}