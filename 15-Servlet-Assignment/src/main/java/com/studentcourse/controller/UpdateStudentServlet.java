package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/update")
public class UpdateStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idStr = req.getParameter("studentId");
		String studentName = req.getParameter("studentName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String ageStr = req.getParameter("age");
		String city = req.getParameter("city");

		int studentId = 0;
		try {
			studentId = Integer.parseInt(idStr);
		} catch (Exception e) {
			req.setAttribute("errorMsg", "Invalid student ID.");
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return;
		}

		String error = validateStudent(studentName, email, phone, ageStr, city);
		if (error != null) {
			Student s = new Student();
			s.setStudentId(studentId);
			s.setStudentName(studentName != null ? studentName : "");
			s.setEmail(email != null ? email : "");
			s.setPhone(phone != null ? phone : "");
			s.setCity(city != null ? city : "");
			try {
				s.setAge(Integer.parseInt(ageStr != null ? ageStr.trim() : "0"));
			} catch (Exception ignored) {
			}
			req.setAttribute("student", s);
			req.setAttribute("errorMsg", error);
			req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(req, resp);
			return;
		}

		Student s = new Student();
		s.setStudentId(studentId);
		s.setStudentName(studentName.trim());
		s.setEmail(email.trim().toLowerCase());
		s.setPhone(phone.trim());
		s.setAge(Integer.parseInt(ageStr.trim()));
		s.setCity(capitalize(city.trim()));

		new StudentDAO().updateStudent(s);
		resp.sendRedirect(req.getContextPath() + "/students");
	}

	private String validateStudent(String name, String email, String phone, String ageStr, String city) {
		if (name == null || name.trim().isEmpty())
			return "Student name is required.";
		if (name.trim().length() < 2)
			return "Student name must be at least 2 characters.";
		if (name.trim().length() > 100)
			return "Student name cannot exceed 100 characters.";
		if (!name.trim().matches("[a-zA-Z\\s]+"))
			return "Student name must contain letters only (no numbers or special characters).";

		if (email == null || email.trim().isEmpty())
			return "Email address is required.";
		if (!email.trim().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
			return "Please enter a valid email address (e.g. rahul@gmail.com).";

		if (phone == null || phone.trim().isEmpty())
			return "Phone number is required.";
		if (!phone.trim().matches("\\d{10}"))
			return "Phone number must be exactly 10 digits (numbers only).";
		if (phone.trim().startsWith("0"))
			return "Phone number should not start with 0.";

		if (ageStr == null || ageStr.trim().isEmpty())
			return "Age is required.";
		try {
			int age = Integer.parseInt(ageStr.trim());
			if (age < 18)
				return "Age must be 18 or above. You entered: " + age + ".";
			if (age > 100)
				return "Please enter a realistic age (18 to 100).";
		} catch (NumberFormatException e) {
			return "Age must be a valid number.";
		}

		if (city == null || city.trim().isEmpty())
			return "City is required.";
		if (!city.trim().matches("[a-zA-Z\\s]+"))
			return "City name must contain letters only.";

		return null;
	}

	private String capitalize(String s) {
		if (s == null || s.isEmpty())
			return s;
		String[] words = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (String w : words) {
			if (w.length() > 0)
				sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase()).append(" ");
		}
		return sb.toString().trim();
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}