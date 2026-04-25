package com.assignment.count;

import java.util.*;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class CountPassed {
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

		long count=list.stream().filter(s -> s.marks >= 60).count();
		System.out.println(count);
	}
}
