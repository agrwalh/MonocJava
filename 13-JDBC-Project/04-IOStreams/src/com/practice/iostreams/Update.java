package com.practice.iostreams;

import java.io.*;
import java.util.Scanner;

public class Update {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter Student ID to update: ");
            int updateId = scanner.nextInt();

            System.out.print("Enter new name: ");
            String newName = scanner.next();

            File inputFile = new File("students.txt");
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(tempFile);

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" ");

                int id = Integer.parseInt(parts[0]);

                if (id == updateId) {

                    fw.write(updateId + " " + newName + "\n");
                    found = true;

                } else {

                    fw.write(line + "\n");
                }
            }

            br.close();
            fw.close();

            if (found) {

                inputFile.delete();
                tempFile.renameTo(inputFile);

                System.out.println("Student updated successfully!");

            } else {

                tempFile.delete();
                System.out.println("Student ID not found!");
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        scanner.close();
    }
}