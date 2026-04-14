package com.supplier.test;
import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityName {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Supplier<String> city = () -> "Pune";

		System.out.print("Enter city (press enter for default): ");
		String input = sc.nextLine();

		if (input == null || input.isEmpty()) {
			System.out.println("City: " + city.get());
		} else {
			System.out.println("City: " + input);
		}

		sc.close();
	}
}