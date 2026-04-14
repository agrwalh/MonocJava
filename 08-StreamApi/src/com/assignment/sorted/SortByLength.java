package com.assignment.sorted;

import java.util.List;

public class SortByLength {
    public static void main(String[] args) {

        List<String> list = List.of("Aman", "Rohit", "Ankit", "Al");

        list.stream()
            .sorted((a, b) -> a.length() - b.length())
            .forEach(System.out::println);
    }
}