package com.assignment4.EducationLMS;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ContentRenderer renderer = new ContentRenderer();

		System.out.print("Enter content type (video/article/quiz): ");
		String type = sc.nextLine();

		Content content = null;


		if (type.equalsIgnoreCase("video")) {
			content = new VideoContent();
		} else if (type.equalsIgnoreCase("article")) {
			content = new ArticleContent();
		} else if (type.equalsIgnoreCase("quiz")) {
			content = new QuizContent();
		} else {
			System.out.println("Invalid content type");
			return;
		}


		renderer.renderContent(content);

		sc.close();
	}
}
