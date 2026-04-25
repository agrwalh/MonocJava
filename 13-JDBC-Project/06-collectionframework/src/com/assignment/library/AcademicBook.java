package com.assignment.library;

class AcademicBook extends Book {
	private String subject;

	AcademicBook(int id, String title, String author, String subject) {
		super(id, title, author);
		if (subject == null || subject.isEmpty())
			throw new IllegalArgumentException("Invalid subject");
		this.subject = subject;
	}

	String getType() {
		return "Academic (" + subject + ")";
	}
}