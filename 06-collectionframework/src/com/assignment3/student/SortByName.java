package com.assignment3.student;

import java.util.*;

class SortByName implements Comparator<Student> {

	public int compare(Student a, Student b) {
		return a.getName().compareToIgnoreCase(b.getName());
	}
}