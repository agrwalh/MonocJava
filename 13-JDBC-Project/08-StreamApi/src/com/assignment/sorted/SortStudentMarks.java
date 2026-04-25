package com.assignment.sorted;

import java.util.List;
import java.util.Comparator;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class SortStudentMarks {
	public static void main(String[] args) {

		List<Student> list = List.of(
				new Student("Aman", 70), 
				new Student("Rohit", 50), 
				new Student("Neha", 90));

		list.stream().sorted(Comparator.comparingInt(s -> s.marks))
				.forEach(s -> System.out.println(s.name + " - " + s.marks));
	}
}