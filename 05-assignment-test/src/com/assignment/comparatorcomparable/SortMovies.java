package com.assignment.comparatorcomparable;

import java.util.*;

class Movie {
	String title;
	int year;

	Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String toString() {
		return title + " - " + year;
	}
}

public class SortMovies {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Movie> list = new ArrayList<>();

		System.out.print("Enter number of movies: ");
		if (!sc.hasNextInt()) {
			System.out.println("Invalid input! Please enter a numeric value.");
			return;
		}
		int n = sc.nextInt();
		if (n <= 0) {
			System.out.println("The number of movies should be greater than zero.");
		}
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("\nEnter details for movie " + (i + 1));

			System.out.print("Enter movie title: ");
			String title = sc.nextLine();

			if (title.trim().isEmpty()) {
				System.out.println("Invalid title! Try again.");
				i--;
				continue;
			}

			System.out.print("Enter release year: ");
			int year = sc.nextInt();
			sc.nextLine();

			if (year <= 1800 || year > 2100) {
				System.out.println("Invalid year! Enter a valid year.");
				i--;
				continue;
			}

			list.add(new Movie(title, year));
		}

		Collections.sort(list, new Comparator<Movie>() {

			public int compare(Movie m1, Movie m2) {

				if (m1.year != m2.year) {
					return m2.year - m1.year;
				}

				return m1.title.compareToIgnoreCase(m2.title);
			}
		});

		System.out.println("\nMovies sorted by Year (Descending) then Title:");

		for (Movie m : list) {
			System.out.println(m);
		}

		sc.close(); 
	}
}