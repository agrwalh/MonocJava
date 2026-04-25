package com.assignment.library;

class Magazine extends Book {
	private int issue;

	Magazine(int id, String title, String author, int issue) {
		super(id, title, author);
		if (issue <= 0)
			throw new IllegalArgumentException("Invalid issue");
		this.issue = issue;
	}

	String getType() {
		return "Magazine (Issue " + issue + ")";
	}
}