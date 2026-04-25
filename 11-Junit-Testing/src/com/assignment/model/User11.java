package com.assignment.model;

public class User11 {

	String name;
	int age;

	public User11(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean isValid() {
		if (name == null || name.isEmpty()) {
			return false;
		}
		if (age <= 0) {
			return false;
		}
		return true;
	}
}