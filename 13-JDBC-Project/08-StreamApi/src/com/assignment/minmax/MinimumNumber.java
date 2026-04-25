package com.assignment.minmax;

import java.util.List;

public class MinimumNumber {
	public static void main(String args[]) {
		List<Integer> list = List.of(50, 111, -10, 98, 0);
		int minimumnumber = list.stream().min((a, b) -> a - b).get();
		System.out.println(minimumnumber);

	}

}
