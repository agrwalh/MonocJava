package com.assignment.filter;

import java.util.*;

class StudentPass {
	String name;
	int marks;

	StudentPass(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class PassStudentFilter {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<StudentPass> list = new ArrayList<>();

		System.out.println("Enter number of students:");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter name and marks:");
			String name = scanner.next();
			int marks = scanner.nextInt();

			list.add(new StudentPass(name, marks));
		}

		System.out.println("Passed students:");

		list.stream().filter(s -> s.marks >= 40).forEach(s -> System.out.println(s.name + " - " + s.marks));
		scanner.close();
	}
}