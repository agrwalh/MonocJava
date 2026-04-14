package com.practice.iostreams;

import java.io.FileWriter;
import java.io.IOException;

public class Create {

    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("students.txt", true); 
            fw.write("3 Alice\n");
            fw.close();

            System.out.println("Student Added");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
