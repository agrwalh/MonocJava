package com.assignment.hospitalapp;

public abstract class HospitalService implements ServiceValidation {

    protected int serviceId;
    protected String patientName;
    protected double consultationFee;

    static {
        System.out.println("Hospital system configuration loaded...");
    }

    public HospitalService(int serviceId, String patientName, double consultationFee) throws InvalidServiceException {

        if(serviceId <= 0)
            throw new InvalidServiceException("Service ID must be positive");

        if(patientName == null || patientName.isEmpty())
            throw new InvalidServiceException("Patient name cannot be empty");

        if(consultationFee < 0)
            throw new InvalidServiceException("Consultation fee cannot be negative");

        this.serviceId = serviceId;
        this.patientName = patientName;
        this.consultationFee = consultationFee;

        System.out.println("HospitalService constructor executed");
    }

    public abstract double calculateFee();

    public void displayService() {

        System.out.println("Service ID: " + serviceId);
        System.out.println("Patient Name: " + patientName);
    }
}