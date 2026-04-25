package com.jdbc.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.main.DBConnection;

public class GetById {
    public static void main(String[] args) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM students WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, 1); // change id

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name") + " " +
                rs.getInt("age") + " " +
                rs.getString("branch") + " " +
                rs.getInt("result")
            );
        }

        con.close();
    }
}
