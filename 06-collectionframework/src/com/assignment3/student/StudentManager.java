package com.assignment3.student;

import java.util.*;

class StudentManager {

	List<Student> students = new ArrayList<>();
	Map<String, List<Student>> deptMap = new HashMap<>();

	Student findStudentById(int id) {
		for (Student s : students) {
			if (s.getId() == id)
				return s;
		}
		return null;
	}

	void addStudent(Student s) {

		if (s == null) {
			System.out.println("Invalid student");
			return;
		}

		for (Student st : students) {
			if (st.getId() == s.getId()) {
				System.out.println("Duplicate ID not allowed");
				return;
			}
		}

		students.add(s);

		deptMap.putIfAbsent(s.getDepartment(), new ArrayList<>());
		deptMap.get(s.getDepartment()).add(s);

		System.out.println("Student Added");
	}

	void display() {

		if (students.isEmpty()) {
			System.out.println("No students available");
			return;
		}

		for (Student s : students) {

			if (!s.hasMarks()) {
				System.out.println(s.getId() + " " + s.getName() + " (No marks)");
			} else {
				System.out.println(s.getId() + " " + s.getName() + " " + s.getDepartment() + " " + s.getType()
						+ " Total:" + s.getTotal());
			}
		}
	}

	void sortByMarks() {

		if (students.isEmpty()) {
			System.out.println("Nothing to sort");
			return;
		}

		Collections.sort(students, new SortByMarks());
		System.out.println("Sorted by Marks");
	}

	void sortByName() {

		if (students.isEmpty()) {
			System.out.println("Nothing to sort");
			return;
		}

		Collections.sort(students, new SortByName());
		System.out.println("Sorted by Name");
	}

	void removeLowStudents() {

		Iterator<Student> it = students.iterator();
		boolean removed = false;

		while (it.hasNext()) {

			Student s = it.next();

			if (s.hasMarks() && s.getTotal() < 100) {

				it.remove();
				removed = true;

				List<Student> list = deptMap.get(s.getDepartment());
				if (list != null) {
					list.remove(s);
					if (list.isEmpty()) {
						deptMap.remove(s.getDepartment());
					}
				}

				System.out.println("Removed: " + s.getName());
			}
		}

		if (!removed) {
			System.out.println("No low students found");
		}
	}

	void displayDeptWise() {

		if (deptMap.isEmpty()) {
			System.out.println("No department data");
			return;
		}

		for (String dept : deptMap.keySet()) {

			System.out.println("Department: " + dept);

			for (Student s : deptMap.get(dept)) {
				System.out.println("  " + s.getName());
			}
		}
	}
}