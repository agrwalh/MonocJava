package com.jdbc.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.main.DBConnection;

public class UpdateName {
    public static void main(String[] args) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "UPDATE students SET name=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, "Harshit");
        ps.setInt(2, 1);

        ps.executeUpdate();

        System.out.println("Name Updated");

        con.close();
    }
}