package com.assignment.hospitalapp;

public class DiagnosticTest extends HospitalService {

	private double testCost;

	public DiagnosticTest(int id, String name, double fee, double testCost) throws InvalidServiceException {

		super(id, name, fee);

		if (testCost < 0)
			throw new InvalidServiceException("Invalid test cost");

		this.testCost = testCost;

		System.out.println("Diagnostic test service created");
	}

	@Override
	public double calculateFee() {
		return consultationFee + testCost;
	}

	@Override
	public boolean validateService() {
		return testCost >= 500;
	}
}