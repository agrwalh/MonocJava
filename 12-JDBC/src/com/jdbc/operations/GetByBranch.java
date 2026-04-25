package com.jdbc.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.main.DBConnection;

public class GetByBranch {
	public static void main(String[] args) throws Exception {

		Connection con = DBConnection.getConnection();

		String query = "SELECT * FROM students WHERE branch=?";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, "CSE");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("name") + " - " + rs.getString("branch"));
		}

		con.close();
	}
}
