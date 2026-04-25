package com.assignment.library;

import java.util.Objects;

abstract class Book implements Comparable<Book> {
	private int id;
	private String title;
	private String author;

	Book(int id, String title, String author) {
		if (id <= 0)
			throw new IllegalArgumentException("Invalid ID");
		if (title == null || title.trim().isEmpty())
			throw new IllegalArgumentException("Invalid title");
		if (author == null || author.trim().isEmpty())
			throw new IllegalArgumentException("Invalid author");

		this.id = id;
		this.title = title;
		this.author = author;
	}

	int getId() {
		return id;
	}

	String getTitle() {
		return title;
	}

	abstract String getType();

	public int compareTo(Book b) {
		return this.title.compareToIgnoreCase(b.title);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Book))
			return false;
		return id == ((Book) o).id;
	}

	public int hashCode() {
		return Objects.hash(id);
	}

	public String toString() {
		return id + " | " + title + " | " + author + " | " + getType();
	}
}