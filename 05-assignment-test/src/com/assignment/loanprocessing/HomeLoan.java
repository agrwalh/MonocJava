package com.assignment.loanprocessing;

class HomeLoan extends Loan implements LoanEligibility {

	public HomeLoan(int loanId, String borrowerName, double principalAmount, double interestRate)
			throws InvalidLoanException {

		super(loanId, borrowerName, principalAmount, interestRate);
		System.out.println("HomeLoan constructor executed");
	}

	@Override
	public double calculateRepayment() {

		double interest = principalAmount * interestRate * 20 / 100;
		return principalAmount + interest;
	}

	@Override
	public boolean checkEligibility() {

		return principalAmount <= 10000000; // 1 crore
	}
}