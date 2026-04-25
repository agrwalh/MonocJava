package com.assignment.map;

import java.util.List;
import java.util.stream.Collectors;

public class DiscountPrices {
    public static void main(String[] args) {
        List<Integer> prices = List.of(1000, 500, 200);

        List<Double> discounted = prices.stream()
                                        .map(p -> p * 0.9) 
                                        .collect(Collectors.toList());

        System.out.println(discounted);
    }
}