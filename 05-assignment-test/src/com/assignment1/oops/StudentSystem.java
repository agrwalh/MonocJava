package com.assignment1.oops;

import java.util.Scanner;

public class StudentSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of Students:");
		int numberofstudents = scanner.nextInt();
		Student[] students = new Student[numberofstudents];

		for (int i = 0; i < students.length; i++) {

			try {

				System.out.println("Enter student type:");
				System.out.println("1. Regular Student");
				System.out.println("2. Scholarship Student");

				int type = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Student ID: ");

				if (!scanner.hasNextInt()) {
					System.out.println("Invalid ID. Please enter a number.");
					scanner.next();
					i--;
					continue;
				}

				int id = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Name: ");
				String name = scanner.nextLine();

				System.out.print("Enter Course: ");
				String course = scanner.nextLine();

				switch (type) {

				case 1:

					System.out.print("Enter Attendance (0-100): ");
					int attendance = scanner.nextInt();

					students[i] = new RegularStudent(id, name, course, attendance);
					break;

				case 2:

					System.out.print("Enter Scholarship Amount: ");
					double amount = scanner.nextDouble();

					students[i] = new ScholarshipStudent(id, name, course, amount);
					break;

				default:

					System.out.println("Invalid student type.");
					i--;
					continue;
				}

			} catch (Exception e) {

				System.out.println("Error: " + e.getMessage());
				i--;
				scanner.nextLine();
			}
		}

		System.out.println("\n--- Student Records ---");

		for (Student s : students) {
			if (s != null) {
				s.displayInfo();
			}
		}

		scanner.close();
	}
}