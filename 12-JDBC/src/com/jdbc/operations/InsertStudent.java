package com.jdbc.operations;


import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.main.DBConnection;

public class InsertStudent {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name, age, branch, result) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "Rohit");
            ps.setInt(2, 21);
            ps.setString(3, "CSE");
            ps.setInt(4, 80);

            ps.executeUpdate();

            System.out.println("Inserted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
