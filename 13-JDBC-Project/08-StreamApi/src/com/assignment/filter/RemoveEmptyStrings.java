package com.assignment.filter;



import java.util.*;


public class RemoveEmptyStrings {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter strings (use spaces):");

        List<String> list = Arrays.asList(scanner.nextLine().split(" "));

        System.out.println("Non-empty strings:");

        list.stream()
                .filter(s -> !s.trim().isEmpty())
                .forEach(System.out::println);
        scanner.close();
    }
}
