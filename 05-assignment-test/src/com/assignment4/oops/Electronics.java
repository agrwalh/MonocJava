package com.assignment4.oops;

class Electronics extends Product {

    private int warrantyMonths;

    public Electronics(int productId, String productName, double basePrice, int warrantyMonths) {

        super(productId, productName, basePrice);  

        if(warrantyMonths < 0)
            throw new IllegalArgumentException("Warranty cannot be negative");

        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public void displayInfo() {

        System.out.println("Electronics Product");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getProductName());
        System.out.println("Price: " + getBasePrice());
        System.out.println("Warranty: " + warrantyMonths + " months");
        System.out.println("----------------------");
    }
}
