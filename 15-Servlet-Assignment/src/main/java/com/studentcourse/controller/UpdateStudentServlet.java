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
		String name = req.getParameter("studentName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String ageStr = req.getParameter("age");
		String city = req.getParameter("city");

		String error = validate(name, email, phone, ageStr, city);
		if (error != null) {
			Student s = new Student();
			s.setStudentId(Integer.parseInt(idStr));
			s.setStudentName(name);
			s.setEmail(email);
			s.setPhone(phone);
			s.setCity(city);
			req.setAttribute("student", s);
			req.setAttribute("errorMsg", error);
			req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(req, resp);
			return;
		}

		Student s = new Student();
		s.setStudentId(Integer.parseInt(idStr.trim()));
		s.setStudentName(name.trim());
		s.setEmail(email.trim());
		s.setPhone(phone.trim());
		s.setAge(Integer.parseInt(ageStr.trim()));
		s.setCity(city.trim());

		new StudentDAO().updateStudent(s);
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
}