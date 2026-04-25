package com.jdbc.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.main.DBConnection;

public class GetByMarks {
    public static void main(String[] args) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM students WHERE result > ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, 80);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("name") + " - " + rs.getInt("result"));
        }

        con.close();
    }
}

//Insert a new student record into the student table.
//Insert 5 student records using batch processing.
//Display all records from the student table.
//Fetch and display a student record based on a given id.
//Display all students belonging to a specific branch.
//Display all students whose marks are greater than a given value.
//Display students whose age lies between two given values.
//Update the name of a student using their id.
//Update both branch and marks of a student based on their id.
//Increase the marks of all students belonging to a specific branch by a given value.
//Delete a student record using their id.
//Delete all students whose marks are below a given threshold.
 