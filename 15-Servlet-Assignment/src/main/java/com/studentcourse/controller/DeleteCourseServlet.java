package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course/delete")
public class DeleteCourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idParam = req.getParameter("id");
		if (idParam == null || idParam.trim().isEmpty()) {
			req.setAttribute("errorMsg", "No course ID provided.");
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.getRequestDispatcher("/WEB-INF/views/course-list.jsp").forward(req, resp);
			return;
		}

		int courseId;
		try {
			courseId = Integer.parseInt(idParam.trim());
		} catch (NumberFormatException e) {
			req.setAttribute("errorMsg", "Invalid course ID.");
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.getRequestDispatcher("/WEB-INF/views/course-list.jsp").forward(req, resp);
			return;
		}

		CourseDAO dao = new CourseDAO();

		if (dao.hasActiveRegistrations(courseId)) {
			req.setAttribute("courseList", dao.getAllCourses());
			req.setAttribute("errorMsg", "Cannot delete this course. Students are actively registered in it. "
					+ "Please change their registration status to Completed or Cancelled first.");
			req.getRequestDispatcher("/WEB-INF/views/course-list.jsp").forward(req, resp);
			return;
		}

		dao.deleteCourse(courseId);
		resp.sendRedirect(req.getContextPath() + "/courses");
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}