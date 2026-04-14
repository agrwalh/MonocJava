package com.practice.iostreams;

import java.io.*;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter ID to delete: ");
            int deleteId = scanner.nextInt();

            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            StringBuilder data = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" ");

                if (Integer.parseInt(parts[0]) != deleteId) {
                    data.append(line).append("\n");
                }
            }

            br.close();

            FileWriter fw = new FileWriter("students.txt");
            fw.write(data.toString());
            fw.close();

            System.out.println("Record deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}