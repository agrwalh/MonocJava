package com.assignment.model;

public class MarksValidator {
	public boolean isValidMarks(int marks) {
		return marks >= 0 && marks <= 100;
	}

}
