package com.assignment.minmax;

import java.util.List;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class MaxStudent {
    public static void main(String[] args) {

        List<Student> list = List.of(
            new Student("Aman", 70),
            new Student("Rohit", 90),
            new Student("Neha", 80)
        );

        Student top = list.stream()
                          .max((s1, s2) -> s1.marks - s2.marks)
                          .get();

        System.out.println(top.name + " - " + top.marks);
    }
}