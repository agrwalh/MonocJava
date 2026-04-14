package com.assignment.map;

import java.util.List;
import java.util.stream.Collectors;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class GraceMarks {
	public static void main(String[] args) {

		List<Student> list = List.of(new Student("Aman", 30), new Student("Rohit", 50), new Student("Neha", 20));

		List<Student> updated = list.stream().map(s -> {
			if (s.marks < 35) {
				return new Student(s.name, s.marks + 5);
			}
			return s;
		}).collect(Collectors.toList());

		updated.forEach(s -> System.out.println(s.name + " - " + s.marks));
	}
}