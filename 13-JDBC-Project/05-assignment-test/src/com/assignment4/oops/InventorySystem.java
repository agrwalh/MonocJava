package com.assignment4.oops;

import java.util.Scanner;

public class InventorySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] inventory = new Product[n];

        for (int i = 0; i < n; i++) {

            try {

                int type;

                while (true) {
                    System.out.print("\nEnter product type (1 = Electronics, 2 = Clothing): ");

                    if (sc.hasNextInt()) {
                        type = sc.nextInt();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid input. Enter number 1 or 2.");
                        sc.nextLine();
                    }
                }

                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Product Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Base Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                if (type == 1) {

                    System.out.print("Enter Warranty Months: ");
                    int warranty = sc.nextInt();
                    sc.nextLine();

                    inventory[i] = new Electronics(id, name, price, warranty);

                } else if (type == 2) {

                    System.out.print("Enter Size: ");
                    String size = sc.nextLine();

                    inventory[i] = new Clothing(id, name, price, size);

                } else {
                    throw new IllegalArgumentException("Product type must be 1 or 2");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
                i--; 
            }
        }

        System.out.println("\n===== INVENTORY =====");

        for (Product p : inventory) {
            p.displayInfo();
        }

        sc.close();
    }
}