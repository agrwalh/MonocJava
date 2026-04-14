package com.assignment.minmax;

import java.util.List;

public class Maxlength {
	public static void main(String args[]) {
		List<String> list = List.of("Rohit","Aman","Gaurav");
		String maxlengthstring = list.stream().max((a,b)->a.length()-b.length()).get();
		System.out.println(maxlengthstring);

	}

}