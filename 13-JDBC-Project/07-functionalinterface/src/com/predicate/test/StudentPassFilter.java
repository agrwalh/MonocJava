package com.predicate.test;

import java.util.*;
import java.util.function.Predicate;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class StudentPassFilter {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<>();

		System.out.println("Enter details of 5 students:");
		for (int i = 1; i <= 5; i++) {
			System.out.print("Enter name: ");
			String name = sc.nextLine();

			System.out.print("Enter marks: ");
			int marks = sc.nextInt();
			sc.nextLine();

			list.add(new Student(name, marks));
		}

		Predicate<Student> isPass = s -> s.marks >= 40;

		System.out.println("\nPassing Students:");
		for (Student s : list) {
			if (isPass.test(s)) {
				System.out.println(s.name + " - " + s.marks);
			}
		}

		sc.close();
	}
}