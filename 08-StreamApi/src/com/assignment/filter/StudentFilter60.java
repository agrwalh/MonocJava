package com.assignment.filter;

import java.util.*;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class StudentFilter60 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<>();

		System.out.println("Enter number of students:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter name and marks:");
			String name = sc.next();
			int marks = sc.nextInt();

			list.add(new Student(name, marks));
		}

		System.out.println("Students with marks >= 60:");

		list.stream().filter(s -> s.marks >= 60).forEach(s -> System.out.println(s.name + " - " + s.marks));
	}
}
