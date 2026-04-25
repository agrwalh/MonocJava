package com.assignment.model;

public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
