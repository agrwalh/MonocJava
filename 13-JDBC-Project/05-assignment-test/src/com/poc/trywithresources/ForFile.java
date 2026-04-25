package com.poc.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;

public class ForFile {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader(
				"/Users/harshagarwal/eclipse-workspace/05-assignment-test/src/com/poc/trywithresources/test.txt"))) {

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
