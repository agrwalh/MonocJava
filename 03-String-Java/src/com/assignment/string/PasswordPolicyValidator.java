package com.assignment.string;

import java.util.Scanner;

public class PasswordPolicyValidator {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The password:");
		String password = scanner.nextLine();

		password = password.replace(" ", "");
		System.out.println("Password after removing spaces becomes: "+password);

		boolean lengthValid = false;
		boolean hasLower = false;
		boolean hasUpper = false;
		boolean hasDigit = false;

		if (password.length() >= 8) {
			lengthValid = true;
		}
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isUpperCase(ch)) {
				hasUpper = true;
			}
			if (Character.isLowerCase(ch)) {
				hasLower = true;
			}
			if (Character.isDigit(ch)) {
				hasDigit = true;
			}
		}
		System.out.println("Length Valid: " + (lengthValid ? "Yes" : "No"));
		System.out.println("Contains UpperCase: " + (hasUpper ? "Yes" : "No"));
		System.out.println("Contains LowerCase: " + (hasLower ? "Yes" : "No"));
		System.out.println("Contains Digit: " + (hasDigit ? "Yes" : "No"));

		if (lengthValid && hasUpper && hasLower && hasDigit) {
			System.out.println("Password is VALID");
		} else {
			System.out.println("Password is INVALID");

			if (!lengthValid)
				System.out.println("Reason: Password must be at least 8 characters");

			if (!hasUpper)
				System.out.println("Reason: Must contain at least one uppercase letter");

			if (!hasLower)
				System.out.println("Reason: Must contain at least one lowercase letter");

			if (!hasDigit)
				System.out.println("Reason: Must contain at least one digit");
		}

		scanner.close();

	}
}
