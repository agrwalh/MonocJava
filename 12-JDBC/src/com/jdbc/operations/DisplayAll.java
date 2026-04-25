package com.jdbc.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.main.DBConnection;

public class DisplayAll {
	public static void main(String[] args) throws Exception {

		Connection con = DBConnection.getConnection();

		String query = "SELECT * FROM students";
		PreparedStatement ps = con.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String branch = rs.getString("branch");
			double result = rs.getInt("result");

			System.out.println(id + " | " + name + " | " + age + " | " + branch + " | " + result);
		}
		rs.close();
		ps.close();
		con.close();

	}
}
