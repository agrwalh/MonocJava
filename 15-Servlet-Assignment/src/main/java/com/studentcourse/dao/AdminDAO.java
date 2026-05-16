package com.studentcourse.dao;

import com.studentcourse.model.Admin;
import com.studentcourse.util.DBConnection;
import java.sql.*;

public class AdminDAO {

	public Admin validateLogin(String username, String password) {
		Admin admin = null;
		String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}
}