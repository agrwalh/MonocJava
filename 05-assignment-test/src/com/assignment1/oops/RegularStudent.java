package com.assignment1.oops;

public class RegularStudent extends Student {

    private int attendance;

    public RegularStudent(int studentId, String name, String course, int attendance){

        // constructor chaining
        super(studentId, name, course);

        // attendance validation
        if(attendance < 0 || attendance > 100){
            throw new IllegalArgumentException("Attendance must be between 0 and 100");
        }

        this.attendance = attendance;
    }

    @Override
    public void displayInfo(){

        super.displayInfo();

        System.out.println("Attendance: " + attendance);
        System.out.println("Type: Regular Student");
        System.out.println();
    }
}