package com.project.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.app.model.CourseMaster;
import com.project.app.util.DBUtil;

public class CourseMasterDAO {

	public List<CourseMaster> getAllCourses() throws SQLException {
		List<CourseMaster> list = new ArrayList<>();

		// Fetch all courses ordered alphabetically by name
		String sql = "SELECT * FROM course_master ORDER BY course_name";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			// Each row = one available course
			while (rs.next()) {
				CourseMaster c = new CourseMaster();
				c.setCourseId(rs.getInt("course_id"));
				c.setCourseName(rs.getString("course_name"));
				c.setFees(rs.getDouble("fees"));
				list.add(c);
			}
		}
		return list;
	}

	public boolean courseExists(String courseName) throws SQLException {

		// Simple existence check using course_name
		String sql = "SELECT course_id FROM course_master WHERE course_name = ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, courseName);
			ResultSet rs = ps.executeQuery();

			// rs.next() returns true if row found = course exists
			return rs.next();
		}
	}

	public CourseMaster getCourseByName(String courseName) throws SQLException {

		String sql = "SELECT * FROM course_master WHERE course_name = ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, courseName);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CourseMaster c = new CourseMaster();
				c.setCourseId(rs.getInt("course_id"));
				c.setCourseName(rs.getString("course_name"));
				c.setFees(rs.getDouble("fees"));
				return c;
			}
		}
		// Course not found in master
		return null;
	}

	public void displayAllCourses() throws SQLException {

		String sql = "SELECT * FROM course_master ORDER BY course_name";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			System.out.println("\n===========================================");
			System.out.println("      AVAILABLE COURSES (COURSE MASTER)    ");
			System.out.println("===========================================");
			System.out.printf("%-5s %-25s %-12s%n", "ID", "Course Name", "Std. Fee");
			System.out.println("-------------------------------------------");

			boolean found = false;
			while (rs.next()) {
				found = true;
				System.out.printf("%-5d %-25s Rs.%-9.0f%n", rs.getInt("course_id"), rs.getString("course_name"),
						rs.getDouble("fees"));
			}

			if (!found)
				System.out.println("No courses found in master.");
			System.out.println("===========================================");
		}
	}
}