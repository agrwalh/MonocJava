package com.assignment4.oops;

class Clothing extends Product {

    private String size;

    public Clothing(int productId, String productName, double basePrice, String size) {

        super(productId, productName, basePrice);  // constructor chaining

        if(size == null || size.trim().isEmpty())
            throw new IllegalArgumentException("Size cannot be empty");

        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public void displayInfo() {

        System.out.println("Clothing Product");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getProductName());
        System.out.println("Price: " + getBasePrice());
        System.out.println("Size: " + size);
        System.out.println("----------------------");
    }
}
