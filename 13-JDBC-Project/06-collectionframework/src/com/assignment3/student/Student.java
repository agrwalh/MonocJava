package com.assignment3.student;

import java.util.*;

abstract class Student {

	private int id;
	private String name;
	private String department;

	private Map<String, Integer> marks = new HashMap<>();

	Student(int id, String name, String department) {

		if (id <= 0)
			throw new IllegalArgumentException("ID must be +ve");

		if (name == null || name.trim().isEmpty())
			throw new IllegalArgumentException("Name cannot be empty");

		if (department == null || department.trim().isEmpty())
			throw new IllegalArgumentException("Department cannot be empty");

		this.id = id;
		this.name = name;
		this.department = department;
	}

	int getId() {
		return id;
	}

	String getName() {
		return name;
	}

	String getDepartment() {
		return department;
	}

	Map<String, Integer> getMarks() {
		return marks;
	}

	void addMarks(String subject, int score) {

		if (subject == null || subject.trim().isEmpty()) {
			System.out.println("Invalid subject");
			return;
		}

		if (score < 0 || score > 100) {
			System.out.println("Marks should be between 0-100");
			return;
		}

		if (marks.containsKey(subject)) {
			System.out.println("Updating marks for " + subject);
		}

		marks.put(subject, score);
	}

	boolean hasMarks() {
		return !marks.isEmpty();
	}

	int getTotal() {
		int sum = 0;
		for (int m : marks.values()) {
			sum += m;
		}
		return sum;
	}

	abstract String getType();
}