package com.assignment.model;

public class PasswordValidator {

	public boolean isValid(String password) {

		if (password == null || password.isEmpty()) {
			return false;
		}

		if (password.length() < 8) {
			return false;
		}

		boolean hasUpper = false;
		boolean hasNumber = false;

		for (char ch : password.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				hasUpper = true;
			}
			if (Character.isDigit(ch)) {
				hasNumber = true;
			}
		}

		return hasUpper && hasNumber;
	}
}
