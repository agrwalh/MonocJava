package com.assignment.comparatorcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Candidate {
	String name;
	int age;

	Candidate(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + " - " + age;
	}
}

public class SortCandidate {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Candidate> list = new ArrayList<>();

		System.out.print("Enter number of candidates: ");
		int n = scanner.nextInt();
		if(n<0) {
			System.out.println("Must Be gr8r than 0");
		}
		scanner.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("Enter name:");
			String name = scanner.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("Invalid name");
				i--;
				continue;
			}

			System.out.println("Enter age:");
			int age = scanner.nextInt();
			scanner.nextLine();

			if (age <= 0) {
				System.out.println("Invalid age");
				i--;
				continue;
			}

			list.add(new Candidate(name, age));
		}

		Collections.sort(list, new Comparator<Candidate>() {

			public int compare(Candidate c1, Candidate c2) {

				int nameCompare = c1.name.compareToIgnoreCase(c2.name);

				if (nameCompare == 0) {
					return c1.age - c2.age;
				}

				return nameCompare;
			}
		});

		System.out.println("Sorted List:");

		for (Candidate c : list) {
			System.out.println(c);
		}
	}
}