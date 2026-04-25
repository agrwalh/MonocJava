package com.assignment.toarray;

import java.util.List;

public class ListToArray {
	public static void main(String args[]) {

		List<String> list = List.of("Java", "Python", "C++");

		String[] arr = list.stream().toArray(size -> new String[size]);

		for (String s : arr) {
			System.out.println(s);
		}
	}

}
