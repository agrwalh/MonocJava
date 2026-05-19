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

@WebServlet("/student/edit")
public class EditStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idParam = req.getParameter("id");
		if (idParam == null || idParam.trim().isEmpty()) {
			req.setAttribute("errorMsg", "No student ID provided.");
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(req, resp);
			return;
		}

		int studentId;
		try {
			studentId = Integer.parseInt(idParam.trim());
		} catch (NumberFormatException e) {
			req.setAttribute("errorMsg", "Invalid student ID.");
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(req, resp);
			return;
		}

		StudentDAO dao = new StudentDAO();
		Student student = dao.getStudentById(studentId);
		if (student == null) {
			req.setAttribute("errorMsg", "Student with ID " + studentId + " not found.");
			req.setAttribute("studentList", dao.getAllStudents());
			req.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(req, resp);
			return;
		}

		req.setAttribute("student", student);
		req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(req, resp);
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}