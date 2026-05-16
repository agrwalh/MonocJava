package com.studentcourse.dao;

import com.studentcourse.model.Student;
import com.studentcourse.util.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentDAO {

	public boolean addStudent(Student s) {
		String sql = "INSERT INTO students (student_name, email, phone, age, city) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, s.getStudentName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPhone());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getCity());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM students ORDER BY student_id DESC";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Student s = new Student();
				s.setStudentId(rs.getInt("student_id"));
				s.setStudentName(rs.getString("student_name"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getString("phone"));
				s.setAge(rs.getInt("age"));
				s.setCity(rs.getString("city"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Student getStudentById(int id) {
		Student s = null;
		String sql = "SELECT * FROM students WHERE student_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s = new Student();
				s.setStudentId(rs.getInt("student_id"));
				s.setStudentName(rs.getString("student_name"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getString("phone"));
				s.setAge(rs.getInt("age"));
				s.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean updateStudent(Student s) {
		String sql = "UPDATE students SET student_name=?, email=?, phone=?, age=?, city=? WHERE student_id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, s.getStudentName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPhone());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getCity());
			ps.setInt(6, s.getStudentId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteStudent(int id) {
		String sql = "DELETE FROM students WHERE student_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean hasRegistrations(int studentId) {
		String sql = "SELECT COUNT(*) FROM registrations WHERE student_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getTotalStudents() {
		String sql = "SELECT COUNT(*) FROM students";
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