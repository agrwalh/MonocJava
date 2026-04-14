package com.assignment.loanprocessing;

class EducationLoan extends Loan implements LoanEligibility {

	public EducationLoan(int loanId, String borrowerName, double principalAmount, double interestRate)
			throws InvalidLoanException {

		super(loanId, borrowerName, principalAmount, interestRate);
		System.out.println("EducationLoan constructor executed");
	}

	@Override
	public double calculateRepayment() {

		double interest = principalAmount * interestRate * 3 / 100;
		return principalAmount + interest;
	}

	@Override
	public boolean checkEligibility() {

		return principalAmount <= 1500000; // 15 lakh
	}
}