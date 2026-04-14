package com.assignment.loanprocessing;

abstract class Loan {

	protected int loanId;
	protected String borrowerName;
	protected double principalAmount;
	protected double interestRate;

	static {
		System.out.println("=== Digital Loan Processing System Started ===");
	}

	public Loan(int loanId, String borrowerName, double principalAmount, double interestRate)
			throws InvalidLoanException {

		if (loanId <= 0) {
			throw new InvalidLoanException("Loan ID must be positive.");
		}

		if (borrowerName == null || borrowerName.trim().isEmpty()) {
			throw new InvalidLoanException("Borrower name cannot be empty.");
		}

		if (!borrowerName.matches("[a-zA-Z ]+")) {
			throw new InvalidLoanException("Borrower name must contain only alphabets.");
		}

		if (principalAmount <= 0) {
			throw new InvalidLoanException("Principal amount must be greater than zero.");
		}

		if (interestRate <= 0 || interestRate > 20) {
			throw new InvalidLoanException("Interest rate must be between 0 and 20.");
		}

		this.loanId = loanId;
		this.borrowerName = borrowerName;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;

		System.out.println("Loan constructor executed");
	}

	public abstract double calculateRepayment();

	public void displayLoanDetails() {

		System.out.println("\n------ Loan Details ------");
		System.out.println("Loan ID: " + loanId);
		System.out.println("Borrower Name: " + borrowerName);
		System.out.println("Principal Amount: " + principalAmount);
		System.out.println("Interest Rate: " + interestRate + "%");
	}
}