package com.assignment1.ecommerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Stock Quantity: ");
        int stock = sc.nextInt();


        Product product = new Product(id, name, price, stock);


        PricingService pricingService = new PricingService();
        InventoryService inventoryService = new InventoryService();
        ProductRenderer renderer = new ProductRenderer();


        System.out.print("Enter Discount %: ");
        double discount = sc.nextDouble();

        System.out.print("Enter Tax %: ");
        double tax = sc.nextDouble();


        double finalPrice = pricingService.calculatePrice(product, discount, tax);


        System.out.print("Enter quantity to purchase: ");
        int qty = sc.nextInt();

        inventoryService.removeStock(product, qty);


        renderer.display(product, finalPrice);

        sc.close();
    }
}
