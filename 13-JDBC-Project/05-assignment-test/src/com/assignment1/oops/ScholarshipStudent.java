package com.assignment1.oops;

public class ScholarshipStudent extends Student {

    private double scholarshipAmount;

    public ScholarshipStudent(int studentId, String name, String course, double scholarshipAmount){

        super(studentId, name, course);

        // scholarship validation
        if(scholarshipAmount < 0){
            throw new IllegalArgumentException("Scholarship amount cannot be negative");
        }

        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public void displayInfo(){

        super.displayInfo();

        System.out.println("Scholarship Amount: " + scholarshipAmount);
        System.out.println("Type: Scholarship Student");
        System.out.println();
    }
}