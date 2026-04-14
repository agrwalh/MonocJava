package com.supplier.test;

import java.util.*;
import java.util.function.Supplier;

public class ProductListGen {
	public static void main(String[] args) {

		Supplier<List<String>> products = () -> {
			List<String> list = new ArrayList<>();
			list.add("Laptop");
			list.add("Mobile");
			list.add("Tablet");
			list.add("Headphones");
			list.add("Keyboard");
			return list;
		};

		List<String> productList = products.get();

		System.out.println("Product List:");
		for (String p : productList) {
			System.out.println(p);
		}
	}
}