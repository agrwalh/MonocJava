package com.assignment.string;

import java.util.Scanner;

public class frequencyCounter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter sentence: ");
		String sentence = scanner.nextLine();

		if (sentence == null || sentence.trim().isEmpty()) {
			System.out.println("Invalid input");
			return;
		}

		sentence = sentence.toLowerCase().trim();

		String[] words = sentence.split(" ");

		boolean[] visited = new boolean[words.length];

		for (int i = 0; i < words.length; i++) {

			if (visited[i] || words[i].equals(""))
				continue;

			int count = 1;

			for (int j = i + 1; j < words.length; j++) {

				if (words[i].equals(words[j])) {
					count++;
					visited[j] = true;
				}
			}

			System.out.println(words[i] + " : " + count);
		}

		scanner.close();
	}
}