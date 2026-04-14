package com.assignment.comparatorcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Flight {
	String airline;
	double fare;

	Flight(String airline, double fare) {
		this.airline = airline;
		this.fare = fare;
	}

	public String toString() {
		return airline + " - " + fare;
	}
}

//Main class
public class SortFlights {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Flight> list = new ArrayList<>();

		System.out.print("Enter number of flights: ");
		if (!scanner.hasNextInt()) {
			System.out.println("Invalid input! Please enter a numeric value.");
			return;
		}
		int n = scanner.nextInt();
		if (n <= 0) {
			System.out.println("Flights Must be Greater than zero and non string value.");
		}
		scanner.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("\nEnter details for flight " + (i + 1));

			System.out.print("Enter airline name: ");
			String airline = scanner.nextLine();

			if (airline.trim().isEmpty()) {
				System.out.println("Invalid airline name! Try again.");
				i--;
				continue;
			}

			System.out.print("Enter fare: ");
			double fare = scanner.nextDouble();
			scanner.nextLine();

			if (fare <= 0) {
				System.out.println("Fare must be greater than 0");
				i--;
				continue;
			}
			list.add(new Flight(airline, fare));
		}

		Collections.sort(list, new Comparator<Flight>() {

			public int compare(Flight f1, Flight f2) {

				return Double.compare(f2.fare, f1.fare);
			}
		});

		System.out.println("\nFlights sorted by Fare (Descending):");

		for (Flight f : list) {
			System.out.println(f);
		}

		scanner.close();
	}
}
