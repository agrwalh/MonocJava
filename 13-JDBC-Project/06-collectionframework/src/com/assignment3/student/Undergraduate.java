package com.assignment3.student;

class Undergraduate extends Student {

	Undergraduate(int id, String name, String dept) {
		super(id, name, dept);
	}

	String getType() {
		return "UG";
	}
}