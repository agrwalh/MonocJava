package com.predicate.test;

import java.util.*;
import java.util.function.Predicate;

public class NonEmptyString {
	public static void main(String[] args) {

		List<String> list = Arrays.asList("", "Java", null, " ");

		Predicate<String> valid = s -> s != null && !s.isEmpty();

		for (String s : list) {
			if (valid.test(s)) {
				System.out.println(s);
			}
		}
	}

}
