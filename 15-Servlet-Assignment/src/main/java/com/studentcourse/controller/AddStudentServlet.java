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

@WebServlet("/student/add")
public class AddStudentServlet extends HttpServlet {

	@Override
	public void init() {
		System.out.println("[AddStudentServlet] init() called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String studentName = req.getParameter("studentName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String ageStr = req.getParameter("age");
		String city = req.getParameter("city");

		String error = validateStudent(studentName, email, phone, ageStr, city);
		if (error != null) {
			req.setAttribute("errorMsg", error);
			req.setAttribute("studentName", studentName);
			req.setAttribute("email", email);
			req.setAttribute("phone", phone);
			req.setAttribute("age", ageStr);
			req.setAttribute("city", city);
			req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
			return;
		}

		Student s = new Student();
		s.setStudentName(studentName.trim());
		s.setEmail(email.trim().toLowerCase());
		s.setPhone(phone.trim());
		s.setAge(Integer.parseInt(ageStr.trim()));
		s.setCity(capitalize(city.trim()));

		new StudentDAO().addStudent(s);
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
		if (email.trim().length() > 100)
			return "Email cannot exceed 100 characters.";

		if (phone == null || phone.trim().isEmpty())
			return "Phone number is required.";
		if (!phone.trim().matches("\\d{10}"))
			return "Phone number must be exactly 10 digits (numbers only, no spaces or dashes).";
		if (phone.trim().startsWith("0"))
			return "Phone number should not start with 0.";

		if (ageStr == null || ageStr.trim().isEmpty())
			return "Age is required.";
		try {
			int age = Integer.parseInt(ageStr.trim());
			if (age < 18)
				return "Age must be 18 or above. You entered: " + age + ".";
			if (age > 100)
				return "Please enter a realistic age (18 to 100). You entered: " + age + ".";
		} catch (NumberFormatException e) {
			return "Age must be a valid number. You entered: \"" + ageStr.trim() + "\".";
		}

		if (city == null || city.trim().isEmpty())
			return "City is required.";
		if (city.trim().length() < 2)
			return "City name must be at least 2 characters.";
		if (city.trim().length() > 50)
			return "City name cannot exceed 50 characters.";
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

	@Override
	public void destroy() {
		System.out.println("[AddStudentServlet] destroy() called");
	}
}