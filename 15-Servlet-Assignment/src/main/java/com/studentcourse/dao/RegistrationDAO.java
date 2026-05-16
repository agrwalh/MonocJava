package com.studentcourse.dao;

import com.studentcourse.model.Registration;
import com.studentcourse.util.DBConnection;
import java.sql.*;
import java.util.*;

public class RegistrationDAO {

	public boolean addRegistration(Registration r) {
		String sql = "INSERT INTO registrations (student_id, course_id, registration_date, status) VALUES (?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, r.getStudentId());
			ps.setInt(2, r.getCourseId());
			ps.setString(3, r.getRegistrationDate());
			ps.setString(4, r.getStatus());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Registration> getAllRegistrations() {
		List<Registration> list = new ArrayList<>();
		String sql = "SELECT r.registration_id, r.student_id, r.course_id, "
				+ "r.registration_date, r.status, s.student_name, c.course_name " + "FROM registrations r "
				+ "JOIN students s ON r.student_id = s.student_id " + "JOIN courses c ON r.course_id = c.course_id "
				+ "ORDER BY r.registration_id DESC";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Registration reg = new Registration();
				reg.setRegistrationId(rs.getInt("registration_id"));
				reg.setStudentId(rs.getInt("student_id"));
				reg.setCourseId(rs.getInt("course_id"));
				reg.setRegistrationDate(rs.getString("registration_date"));
				reg.setStatus(rs.getString("status"));
				reg.setStudentName(rs.getString("student_name"));
				reg.setCourseName(rs.getString("course_name"));
				list.add(reg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateStatus(int registrationId, String newStatus) {
		String sql = "UPDATE registrations SET status = ? WHERE registration_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, newStatus);
			ps.setInt(2, registrationId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteRegistration(int registrationId) {
		String sql = "DELETE FROM registrations WHERE registration_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, registrationId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isDuplicateActiveRegistration(int studentId, int courseId) {
		String sql = "SELECT COUNT(*) FROM registrations WHERE student_id = ? AND course_id = ? AND status = 'Active'";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getTotalRegistrations() {
		String sql = "SELECT COUNT(*) FROM registrations";
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