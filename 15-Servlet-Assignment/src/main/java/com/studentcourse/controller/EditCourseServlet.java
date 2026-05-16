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

@WebServlet("/course/edit")
public class EditCourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idParam = req.getParameter("id");
		if (idParam == null) {
			resp.sendRedirect(req.getContextPath() + "/courses");
			return;
		}

		Course course = new CourseDAO().getCourseById(Integer.parseInt(idParam));
		if (course == null) {
			resp.sendRedirect(req.getContextPath() + "/courses");
			return;
		}

		req.setAttribute("course", course);
		req.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(req, resp);
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}