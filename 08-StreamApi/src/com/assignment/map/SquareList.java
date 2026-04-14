package com.assignment.map;

import java.util.*;
import java.util.stream.*;

public class SquareList {
	public static void main(String[] args) {

		List<Integer> list = List.of(5, 10, 25);

		List<Integer> squared = list.stream().map(n -> n * n).collect(Collectors.toList());

		System.out.println(squared);
	}
}
