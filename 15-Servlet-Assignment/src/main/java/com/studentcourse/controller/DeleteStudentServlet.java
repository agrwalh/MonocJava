package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/delete")
public class DeleteStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idParam = req.getParameter("id");
		if (idParam == null) {
			resp.sendRedirect(req.getContextPath() + "/students");
			return;
		}

		int studentId = Integer.parseInt(idParam);
		StudentDAO dao = new StudentDAO();

		if (dao.hasRegistrations(studentId)) {
			req.setAttribute("studentList", dao.getAllStudents());
			req.setAttribute("errorMsg",
					"Cannot delete. This student is registered in a course. Remove the registration first.");
			req.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(req, resp);
			return;
		}

		dao.deleteStudent(studentId);
		resp.sendRedirect(req.getContextPath() + "/students");
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}