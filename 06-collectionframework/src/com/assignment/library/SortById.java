package com.assignment.library;

import java.util.Comparator;

class SortById implements Comparator<Book> {
	public int compare(Book a, Book b) {
		return a.getId() - b.getId();
	}
}