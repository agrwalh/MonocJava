package com.assignment.hospitalapp;

public class Surgery extends HospitalService {

	private double surgeryCharges;

	public Surgery(int id, String name, double fee, double surgeryCharges) throws InvalidServiceException {

		super(id, name, fee);

		if (surgeryCharges < 0)
			throw new InvalidServiceException("Invalid surgery charges");

		this.surgeryCharges = surgeryCharges;

		System.out.println("Surgery service created");
	}

	@Override
	public double calculateFee() {
		return consultationFee + surgeryCharges;
	}

	@Override
	public boolean validateService() {
		return surgeryCharges > 5000;
	}
}
