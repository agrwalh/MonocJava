package com.practice.iostreams;

import java.io.*;

public class Read {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader("students.txt"));

		String line;
		boolean isEmpty=false;

		System.out.println("Student List:");

		while ((line = br.readLine()) != null) {
			System.out.println(line);
			isEmpty=false;
		}if(isEmpty) {
			System.out.println("Nothing present.");
		}
		

		br.close();
	}
}