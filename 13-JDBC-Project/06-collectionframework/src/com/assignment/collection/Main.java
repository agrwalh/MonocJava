package com.assignment.collection;

import java.util.*;

abstract class Book {
	int bookId;
	String title;
	String author;

	Book(int id, String title, String author) {
		this.bookId = id;
		this.title = title;
		this.author = author;
	}

	abstract String getType();
}

class AcademicBook extends Book {
	String subject;

	AcademicBook(int id, String title, String author, String subject) {
		super(id, title, author);
		this.subject = subject;
	}

	String getType() {
		return "Academic";
	}
}

class Magazine extends Book {
	int issueNumber;

	Magazine(int id, String title, String author, int issue) {
		super(id, title, author);
		this.issueNumber = issue;
	}

	String getType() {
		return "Magazine";
	}
}

class SortByTitle implements Comparator<Book> {
	public int compare(Book a, Book b) {
		return a.title.compareTo(b.title);
	}
}

class Library {

	Set<Book> books = new HashSet<>();

	Queue<Book> queue = new LinkedList<>();

	void addBook(Book b) {
		for (Book bk : books) {
			if (bk.bookId == b.bookId) {
				System.out.println("Duplicate Book ID");
				return;
			}
		}

		books.add(b);
		System.out.println("Book Added");
	}

	void display() {
		for (Book b : books) {
			System.out.println(b.bookId + " " + b.title + " " + b.author + " " + b.getType());
		}
	}

	void sortBooks() {
		List<Book> list = new ArrayList<>(books);
		Collections.sort(list, new SortByTitle());

		for (Book b : list) {
			System.out.println(b.title);
		}
	}

	Book findBook(int id) {
		for (Book b : books) {
			if (b.bookId == id)
				return b;
		}
		return null;
	}

	void requestIssue(int id) {
		Book b = findBook(id);

		if (b == null) {
			System.out.println("Not found");
			return;
		}

		queue.add(b);
		System.out.println("Added to queue");
	}

	void processIssue() {
		if (queue.isEmpty()) {
			System.out.println("Queue empty");
			return;
		}

		Book b = queue.poll();
		System.out.println("Issued: " + b.title);
	}

	void removeBook(int id) {
		Iterator<Book> it = books.iterator();

		while (it.hasNext()) {
			if (it.next().bookId == id) {
				it.remove();
				System.out.println("Removed");
				return;
			}
		}

		System.out.println("Not found");
	}
}

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Library lib = new Library();

		while (true) {

			System.out.println("\n==== MENU ====");
			System.out.println("1. Add Book");
			System.out.println("2. Display");
			System.out.println("3. Sort");
			System.out.println("4. Request Issue");
			System.out.println("5. Process Issue");
			System.out.println("6. Remove Book");
			System.out.println("7. Exit");

			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				System.out.print("Type (1-Academic, 2-Magazine): ");
				int type = sc.nextInt();

				System.out.print("ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Title: ");
				String title = sc.nextLine();

				System.out.print("Author: ");
				String author = sc.nextLine();

				if (type == 1) {
					System.out.print("Subject: ");
					String subject = sc.nextLine();
					lib.addBook(new AcademicBook(id, title, author, subject));
				} else {
					System.out.print("Issue No: ");
					int issue = sc.nextInt();
					lib.addBook(new Magazine(id, title, author, issue));
				}
				break;

			case 2:
				lib.display();
				break;

			case 3:
				lib.sortBooks();
				break;

			case 4:
				System.out.print("Enter ID: ");
				lib.requestIssue(sc.nextInt());
				break;

			case 5:
				lib.processIssue();
				break;

			case 6:
				System.out.print("Enter ID: ");
				lib.removeBook(sc.nextInt());
				break;

			case 7:
				return;
			}
		}
	}
}
