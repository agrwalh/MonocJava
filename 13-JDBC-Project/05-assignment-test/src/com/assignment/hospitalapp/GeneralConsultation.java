package com.assignment.hospitalapp;

public class GeneralConsultation extends HospitalService {

    public GeneralConsultation(int id, String name, double fee) throws InvalidServiceException {
        super(id, name, fee);
        System.out.println("General Consultation created");
    }

    @Override
    public double calculateFee() {
        return consultationFee;
    }

    @Override
    public boolean validateService() {
        return consultationFee >= 200;
    }
}
