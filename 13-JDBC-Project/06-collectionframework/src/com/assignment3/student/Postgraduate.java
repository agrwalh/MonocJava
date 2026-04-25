package com.assignment3.student;

class Postgraduate extends Student {

	Postgraduate(int id, String name, String dept) {
		super(id, name, dept);
	}

	String getType() {
		return "PG";
	}
}