package com.assignment.string;

import java.util.Scanner;

public class EmailAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Email:");
		String email = scanner.nextLine();
		email = email.trim();
		if (!email.contains("@")) {
			System.out.println("Invalid email. '@' symbol missing.");
			return;
		}
		email = email.toLowerCase();
		int atIndex = email.indexOf("@");
		String username = email.substring(0, atIndex);
		String domain = email.substring(atIndex + 1);
		boolean isGmail = domain.equalsIgnoreCase("gmail.com");
		int length = username.length();
		boolean containsDigits = false;
		for (char ch : username.toCharArray()) {
			if (Character.isDigit(ch)) {
				containsDigits = true;
				break;
			}
		}
		String modifiedUsername = username.replace('.', '_');

		// Output
		System.out.println("Username: " + username);
		System.out.println("Domain: " + domain);
		System.out.println("Total characters in username: " + length);
		System.out.println("Contains digits: " + (containsDigits ? "Yes" : "No"));
		System.out.println("Modified username: " + modifiedUsername);


		scanner.close();

	}

}
