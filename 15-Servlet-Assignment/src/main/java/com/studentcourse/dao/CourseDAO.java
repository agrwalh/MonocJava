package com.studentcourse.dao;

import com.studentcourse.model.Course;
import com.studentcourse.util.DBConnection;
import java.sql.*;
import java.util.*;

public class CourseDAO {

	public boolean addCourse(Course c) {
		String sql = "INSERT INTO courses (course_name, duration, fees, trainer_name) VALUES (?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, c.getCourseName());
			ps.setString(2, c.getDuration());
			ps.setDouble(3, c.getFees());
			ps.setString(4, c.getTrainerName());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<>();
		String sql = "SELECT * FROM courses ORDER BY course_id DESC";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Course c = new Course();
				c.setCourseId(rs.getInt("course_id"));
				c.setCourseName(rs.getString("course_name"));
				c.setDuration(rs.getString("duration"));
				c.setFees(rs.getDouble("fees"));
				c.setTrainerName(rs.getString("trainer_name"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Course getCourseById(int id) {
		Course c = null;
		String sql = "SELECT * FROM courses WHERE course_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = new Course();
				c.setCourseId(rs.getInt("course_id"));
				c.setCourseName(rs.getString("course_name"));
				c.setDuration(rs.getString("duration"));
				c.setFees(rs.getDouble("fees"));
				c.setTrainerName(rs.getString("trainer_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean updateCourse(Course c) {
		String sql = "UPDATE courses SET course_name=?, duration=?, fees=?, trainer_name=? WHERE course_id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, c.getCourseName());
			ps.setString(2, c.getDuration());
			ps.setDouble(3, c.getFees());
			ps.setString(4, c.getTrainerName());
			ps.setInt(5, c.getCourseId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCourse(int id) {
		String sql = "DELETE FROM courses WHERE course_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean hasActiveRegistrations(int courseId) {
		String sql = "SELECT COUNT(*) FROM registrations WHERE course_id = ? AND status = 'Active'";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getTotalCourses() {
		String sql = "SELECT COUNT(*) FROM courses";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}