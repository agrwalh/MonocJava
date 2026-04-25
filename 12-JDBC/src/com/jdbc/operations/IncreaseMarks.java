package com.jdbc.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.main.DBConnection;

public class IncreaseMarks {
	public static void main(String[] args) throws Exception {

		Connection con = DBConnection.getConnection();

		String query = "UPDATE students SET result = result + ? WHERE branch=?";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, 5);
		ps.setString(2, "CSE");

		ps.executeUpdate();

		System.out.println("Marks Increased");

		con.close();
	}
}