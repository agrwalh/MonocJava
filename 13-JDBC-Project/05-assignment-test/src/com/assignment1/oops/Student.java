package com.assignment1.oops;

public class Student {

	private int studentId;
	private String name;
	private String course;

	public Student(int studentId, String name, String course) {

		
		if (studentId <= 0) {
			throw new IllegalArgumentException("Student ID must be positive");
		}

		
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}


		if (course == null || course.trim().isEmpty()) {
			throw new IllegalArgumentException("Course cannot be empty");
		}

		this.studentId = studentId;
		this.name = name;
		this.course = course;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}

	public void displayInfo() {
		System.out.println("Student ID: " + studentId);
		System.out.println("Name: " + name);
		System.out.println("Course: " + course);
	}
}