package com.jdbc.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.main.DBConnection;

public class UpdateBranchMarks {
	public static void main(String[] args) throws Exception {

		Connection con = DBConnection.getConnection();

		String query = "UPDATE students SET branch=?, result=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, "ECE");
		ps.setInt(2, 95);
		ps.setInt(3, 1);

		ps.executeUpdate();

		System.out.println("Updated Successfully");

		con.close();
	}
}