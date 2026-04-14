package com.assignment3.student;

import java.util.*;

class MenuHandler {

	StudentManager manager = new StudentManager();
	Scanner sc = new Scanner(System.in);

	void start() {

		while (true) {

			System.out.println("\n==== MENU ====");
			System.out.println("1. Add Student");
			System.out.println("2. Add Marks");
			System.out.println("3. Display");
			System.out.println("4. Sort by Marks");
			System.out.println("5. Sort by Name");
			System.out.println("6. Remove Low Students");
			System.out.println("7. Department View");
			System.out.println("8. Exit");

			if (!sc.hasNextInt()) {
				System.out.println("Invalid input");
				sc.next();
				continue;
			}

			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				addStudent();
				break;

			case 2:
				addMarks();
				break;

			case 3:
				manager.display();
				break;

			case 4:
				manager.sortByMarks();
				break;

			case 5:
				manager.sortByName();
				break;

			case 6:
				manager.removeLowStudents();
				break;

			case 7:
				manager.displayDeptWise();
				break;

			case 8:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}

	void addStudent() {

		System.out.print("Type (1-UG, 2-PG): ");
		if (!sc.hasNextInt()) {
			System.out.println("Invalid type (must be number)");
			sc.next();
			return;
		}
		int type = sc.nextInt();

		System.out.print("ID: ");
		if (!sc.hasNextInt()) {
			System.out.println("Invalid ID (must be number)");
			sc.next();
			return;
		}
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Dept: ");
		String dept = sc.nextLine();

		try {
			if (type == 1)
				manager.addStudent(new Undergraduate(id, name, dept));
			else if (type == 2)
				manager.addStudent(new Postgraduate(id, name, dept));
			else
				System.out.println("Invalid type selected");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void addMarks() {

		System.out.print("Enter ID: ");
		if (!sc.hasNextInt()) {
			System.out.println("Invalid ID (must be number)");
			sc.next();
			return;
		}
		int id = sc.nextInt();
		sc.nextLine();

		Student s = manager.findStudentById(id);

		if (s == null) {
			System.out.println("Student not found");
			return;
		}

		System.out.print("Subject: ");
		String sub = sc.nextLine();

		System.out.print("Marks: ");
		if (!sc.hasNextInt()) {
			System.out.println("Invalid marks (must be number)");
			sc.next();
			return;
		}
		int marks = sc.nextInt();

		s.addMarks(sub, marks);
	}
}