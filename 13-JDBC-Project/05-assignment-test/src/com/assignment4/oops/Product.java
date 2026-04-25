package com.assignment4.oops;

abstract class Product {

    private int productId;
    private String productName;
    private double basePrice;

    // Constructor
    public Product(int productId, String productName, double basePrice) {

        if(productId <= 0)
            throw new IllegalArgumentException("Product ID must be positive");

        if(productName == null || productName.trim().isEmpty())
            throw new IllegalArgumentException("Product name cannot be empty");

        if(basePrice <= 0)
            throw new IllegalArgumentException("Price must be greater than zero");

        this.productId = productId;
        this.productName = productName;
        this.basePrice = basePrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // abstract method for polymorphism
    public abstract void displayInfo();
}
