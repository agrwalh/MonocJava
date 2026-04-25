package com.assignment.string;

import java.util.Scanner;

public class SentenceFormatter 
{
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Sentence:");
		String sentence=scanner.nextLine();
		sentence=sentence.trim();
		sentence=sentence.toLowerCase();
		sentence = sentence.substring(0,1).toUpperCase() + sentence.substring(1);
		sentence=sentence.replace("fun", "interesting");
		String words[]=sentence.split(" ");
		int totalWords=words.length;
		String firstWord=words[0];
		String lastWord=words[words.length-1];
		System.out.println("Formatted Sentence: "+sentence);
		System.out.println("Total Words: "+totalWords);
		System.out.println("First Word: "+firstWord);
		System.out.println("Formatted Sentence: "+lastWord);
		
		scanner.close();
		
		
	}

}
