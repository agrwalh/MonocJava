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
		System.out.println("AddStudentServlet initialized");
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

		String name = req.getParameter("studentName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String ageStr = req.getParameter("age");
		String city = req.getParameter("city");

		String error = validate(name, email, phone, ageStr, city);
		if (error != null) {
			req.setAttribute("errorMsg", error);
			req.setAttribute("studentName", name);
			req.setAttribute("email", email);
			req.setAttribute("phone", phone);
			req.setAttribute("age", ageStr);
			req.setAttribute("city", city);
			req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
			return;
		}

		Student s = new Student();
		s.setStudentName(name.trim());
		s.setEmail(email.trim());
		s.setPhone(phone.trim());
		s.setAge(Integer.parseInt(ageStr.trim()));
		s.setCity(city.trim());

		new StudentDAO().addStudent(s);
		resp.sendRedirect(req.getContextPath() + "/students");
	}

	private String validate(String name, String email, String phone, String ageStr, String city) {
		if (name == null || name.trim().isEmpty())
			return "Student name is required.";
		if (email == null || email.trim().isEmpty())
			return "Email is required.";
		if (phone == null || phone.trim().isEmpty())
			return "Phone is required.";
		if (city == null || city.trim().isEmpty())
			return "City is required.";
		if (ageStr == null || ageStr.trim().isEmpty())
			return "Age is required.";
		try {
			if (Integer.parseInt(ageStr.trim()) < 18)
				return "Age must be 18 or above.";
		} catch (NumberFormatException e) {
			return "Age must be a valid number.";
		}
		return null;
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}

	@Override
	public void destroy() {
		System.out.println("AddStudentServlet destroyed");
	}
}