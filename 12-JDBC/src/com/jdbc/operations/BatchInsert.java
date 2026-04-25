package com.jdbc.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.main.DBConnection;

public class BatchInsert {
	public static void main(String[] args) throws Exception {

		Connection con = DBConnection.getConnection();

		String query = "INSERT INTO students(name, age, branch, result) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);

		for (int i = 1; i <= 5; i++) {
			ps.setString(1, "Student" + i);
			ps.setInt(2, 20 + i);
			ps.setString(3, "IT");
			ps.setInt(4, 70 + i);

			ps.addBatch(); // store
		}

		ps.executeBatch(); // run all

		System.out.println("Batch Insert Done");

		con.close();
	}
}
