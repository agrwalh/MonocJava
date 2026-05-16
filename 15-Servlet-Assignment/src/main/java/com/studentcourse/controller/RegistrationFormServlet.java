package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registration/add")
public class RegistrationFormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		req.setAttribute("studentList", new StudentDAO().getAllStudents());
		req.setAttribute("courseList", new CourseDAO().getAllCourses());
		req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String studentIdStr = req.getParameter("studentId");
		String courseIdStr = req.getParameter("courseId");
		String registrationDate = req.getParameter("registrationDate");
		String status = req.getParameter("status");

		if (studentIdStr == null || studentIdStr.isEmpty() || courseIdStr == null || courseIdStr.isEmpty()
				|| registrationDate == null || registrationDate.isEmpty() || status == null || status.isEmpty()) {

			req.setAttribute("errorMsg", "All fields are required.");
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		int studentId = Integer.parseInt(studentIdStr);
		int courseId = Integer.parseInt(courseIdStr);

		RegistrationDAO regDAO = new RegistrationDAO();
		if ("Active".equals(status) && regDAO.isDuplicateActiveRegistration(studentId, courseId)) {
			req.setAttribute("errorMsg", "This student is already actively registered for this course.");
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		Registration reg = new Registration();
		reg.setStudentId(studentId);
		reg.setCourseId(courseId);
		reg.setRegistrationDate(registrationDate);
		reg.setStatus(status);

		regDAO.addRegistration(reg);
		resp.sendRedirect(req.getContextPath() + "/registrations");
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}