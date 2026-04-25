package com.assignment.string;

import java.util.Scanner;

public class FileNameValidator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = scanner.nextLine();

		if (fileName == null || fileName.trim().isEmpty()) {
			System.out.println("Invalid file name");
			return;
		}

		fileName = fileName.trim();

		int lastDot = fileName.lastIndexOf('.');

		if (lastDot == -1 || lastDot == fileName.length() - 1) {
			System.out.println("Invalid file format");
			return;
		}

		String namePart = fileName.substring(0, lastDot);
		String extension = fileName.substring(lastDot + 1);

		boolean isPdf = extension.equalsIgnoreCase("pdf");

		String formattedName = namePart.replace("_", " ").toUpperCase();

		boolean containsFinal = namePart.toLowerCase().contains("final");

		System.out.println("File Name: " + formattedName);
		System.out.println("Extension: " + extension);
		System.out.println("Is PDF file: " + (isPdf ? "Yes" : "No"));
		System.out.println("Contains 'final': " + (containsFinal ? "Yes" : "No"));

		scanner.close();
	}
}