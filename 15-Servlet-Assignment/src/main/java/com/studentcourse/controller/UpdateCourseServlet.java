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

@WebServlet("/course/update")
public class UpdateCourseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idStr = req.getParameter("courseId");
		String name = req.getParameter("courseName");
		String duration = req.getParameter("duration");
		String feesStr = req.getParameter("fees");
		String trainerName = req.getParameter("trainerName");

		String error = validate(name, duration, feesStr, trainerName);
		if (error != null) {
			Course c = new Course();
			c.setCourseId(Integer.parseInt(idStr));
			c.setCourseName(name);
			c.setDuration(duration);
			c.setTrainerName(trainerName);
			req.setAttribute("course", c);
			req.setAttribute("errorMsg", error);
			req.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(req, resp);
			return;
		}

		Course c = new Course();
		c.setCourseId(Integer.parseInt(idStr.trim()));
		c.setCourseName(name.trim());
		c.setDuration(duration.trim());
		c.setFees(Double.parseDouble(feesStr.trim()));
		c.setTrainerName(trainerName.trim());

		new CourseDAO().updateCourse(c);
		resp.sendRedirect(req.getContextPath() + "/courses");
	}

	private String validate(String name, String duration, String feesStr, String trainerName) {
		if (name == null || name.trim().isEmpty())
			return "Course name is required.";
		if (duration == null || duration.trim().isEmpty())
			return "Duration is required.";
		if (trainerName == null || trainerName.trim().isEmpty())
			return "Trainer name is required.";
		if (feesStr == null || feesStr.trim().isEmpty())
			return "Fees are required.";
		try {
			if (Double.parseDouble(feesStr.trim()) <= 0)
				return "Fees must be greater than 0.";
		} catch (NumberFormatException e) {
			return "Fees must be a valid number.";
		}
		return null;
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}