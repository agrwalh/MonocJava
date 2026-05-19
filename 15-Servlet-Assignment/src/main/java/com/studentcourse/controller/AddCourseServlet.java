package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course/add")
public class AddCourseServlet extends HttpServlet {

	@Override
	public void init() {
		System.out.println("[AddCourseServlet] init() called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String courseName = req.getParameter("courseName");
		String duration = req.getParameter("duration");
		String feesStr = req.getParameter("fees");
		String trainerName = req.getParameter("trainerName");

		String error = validateCourse(courseName, duration, feesStr, trainerName);
		if (error != null) {
			req.setAttribute("errorMsg", error);
			req.setAttribute("courseName", courseName);
			req.setAttribute("duration", duration);
			req.setAttribute("fees", feesStr);
			req.setAttribute("trainerName", trainerName);
			req.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(req, resp);
			return;
		}

		Course c = new Course();
		c.setCourseName(courseName.trim());
		c.setDuration(duration.trim());
		c.setFees(Double.parseDouble(feesStr.trim()));
		c.setTrainerName(trainerName.trim());

		new CourseDAO().addCourse(c);
		resp.sendRedirect(req.getContextPath() + "/courses");
	}

	private String validateCourse(String courseName, String duration, String feesStr, String trainerName) {
		if (courseName == null || courseName.trim().isEmpty())
			return "Course name is required.";
		if (courseName.trim().length() < 3)
			return "Course name must be at least 3 characters.";
		if (courseName.trim().length() > 100)
			return "Course name cannot exceed 100 characters.";

		if (duration == null || duration.trim().isEmpty())
			return "Duration is required (e.g. 3 Months, 6 Weeks).";
		if (duration.trim().length() < 2)
			return "Please enter a valid duration (e.g. 3 Months).";

		if (trainerName == null || trainerName.trim().isEmpty())
			return "Trainer name is required.";
		if (trainerName.trim().length() < 2)
			return "Trainer name must be at least 2 characters.";
		if (!trainerName.trim().matches("[a-zA-Z\\s.]+"))
			return "Trainer name must contain letters only (dots allowed for Mr./Ms.).";

		if (feesStr == null || feesStr.trim().isEmpty())
			return "Fees are required.";
		try {
			double fees = Double.parseDouble(feesStr.trim());
			if (fees <= 0)
				return "Fees must be greater than 0. You entered: " + feesStr.trim() + ".";
			if (fees > 10000000)
				return "Please enter a realistic fee amount.";
			String[] parts = feesStr.trim().split("\\.");
			if (parts.length == 2 && parts[1].length() > 2)
				return "Fees can have at most 2 decimal places (e.g. 1500.50).";
		} catch (NumberFormatException e) {
			return "Fees must be a valid number (e.g. 15000 or 1500.50).";
		}

		return null;
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}

	@Override
	public void destroy() {
		System.out.println("[AddCourseServlet] destroy() called");
	}
}