package com.assignment3.student;

import java.util.*;

class SortByMarks implements Comparator<Student> {

	public int compare(Student a, Student b) {
		return b.getTotal() - a.getTotal();
	}
}