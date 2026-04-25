package com.jdbc.operations;

//package com.jdbc.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.main.DBConnection;

public class GetByAgeRange {
	public static void main(String[] args) throws Exception {

		Connection con = DBConnection.getConnection();

		String query = "SELECT * FROM students WHERE age BETWEEN ? AND ?";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, 20);
		ps.setInt(2, 22);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("name") + " - " + rs.getInt("age"));
		}

		con.close();
	}
}
