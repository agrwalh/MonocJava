package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/student";
		String username = "root";
		String password = "Laa017@@";

		try {

			Connection con = DriverManager.getConnection(url, username, password);

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
