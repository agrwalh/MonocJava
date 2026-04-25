package com.assignment.count;

import java.util.List;

class Student2 {
	String name;
	int marks;

	Student2(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class CountStudentPass {
	public static void main(String[] args) {

		List<Student2> list = List.of(new Student2("Aman", 20), new Student2("Rohit", 60), new Student2("Neha", 45));

		long count = list.stream().filter(s -> s.marks >= 40).count();

		System.out.println("Passed: " + count);
	}
}