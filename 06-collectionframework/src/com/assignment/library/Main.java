package com.assignment.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager m = new LibraryManager();

        while (true) {
            System.out.println("\n========= LIBRARY MENU =========");
            System.out.println("1. Add Academic Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Show All Books");
            System.out.println("4. Sort by Title");
            System.out.println("5. Sort by ID");
            System.out.println("6. Request Book Issue");
            System.out.println("7. Process Issue");
            System.out.println("8. Remove Book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id1 = sc.nextInt();
                        System.out.print("Enter Title: ");
                        String t1 = sc.next();
                        System.out.print("Enter Author: ");
                        String a1 = sc.next();
                        System.out.print("Enter Subject: ");
                        String sub = sc.next();
                        m.add(new AcademicBook(id1, t1, a1, sub));
                        break;

                    case 2:
                        System.out.print("Enter ID: ");
                        int id2 = sc.nextInt();
                        System.out.print("Enter Title: ");
                        String t2 = sc.next();
                        System.out.print("Enter Author: ");
                        String a2 = sc.next();
                        System.out.print("Enter Issue Number: ");
                        int issue = sc.nextInt();
                        m.add(new Magazine(id2, t2, a2, issue));
                        break;
                    case 3:
                        m.show(); break;

                    case 4:
                        m.sortTitle(); break;

                    case 5:
                        m.sortId(); break;

                    case 6:
                        System.out.print("Enter Book ID: ");
                        m.request(sc.nextInt()); break;

                    case 7:
                        m.process(); break;

                    case 8:
                        System.out.print("Enter Book ID to remove: ");
                        m.remove(sc.nextInt()); break;

                    case 9:
                        System.out.println("Exiting... 👋");
                        return;

                    default:
                        System.out.println("❌ Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("⚠ Invalid input, try again");
                sc.nextLine();
            }
        }
    }
}