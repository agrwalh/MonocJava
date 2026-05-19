package com.studentcourse.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
		req.setAttribute("todayDate", LocalDate.now().toString());
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

		String error = validateRegistration(studentIdStr, courseIdStr, registrationDate, status);

		if (error != null) {
			req.setAttribute("errorMsg", error);
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.setAttribute("todayDate", LocalDate.now().toString());
			req.setAttribute("selStudentId", studentIdStr);
			req.setAttribute("selCourseId", courseIdStr);
			req.setAttribute("selDate", registrationDate);
			req.setAttribute("selStatus", status);
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		int studentId = Integer.parseInt(studentIdStr.trim());
		int courseId = Integer.parseInt(courseIdStr.trim());

		RegistrationDAO regDAO = new RegistrationDAO();
		if ("Active".equals(status) && regDAO.isDuplicateActiveRegistration(studentId, courseId)) {
			req.setAttribute("errorMsg", "This student is already ACTIVELY registered for this course. "
					+ "Duplicate Active registrations are not allowed.");
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.setAttribute("todayDate", LocalDate.now().toString());
			req.setAttribute("selStudentId", studentIdStr);
			req.setAttribute("selCourseId", courseIdStr);
			req.setAttribute("selDate", registrationDate);
			req.setAttribute("selStatus", status);
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		if (new StudentDAO().getStudentById(studentId) == null) {
			req.setAttribute("errorMsg", "Selected student does not exist.");
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.setAttribute("todayDate", LocalDate.now().toString());
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		if (new CourseDAO().getCourseById(courseId) == null) {
			req.setAttribute("errorMsg", "Selected course does not exist.");
			req.setAttribute("studentList", new StudentDAO().getAllStudents());
			req.setAttribute("courseList", new CourseDAO().getAllCourses());
			req.setAttribute("todayDate", LocalDate.now().toString());
			req.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(req, resp);
			return;
		}

		Registration reg = new Registration();
		reg.setStudentId(studentId);
		reg.setCourseId(courseId);
		reg.setRegistrationDate(registrationDate.trim());
		reg.setStatus(status.trim());

		regDAO.addRegistration(reg);
		resp.sendRedirect(req.getContextPath() + "/registrations");
	}

	private String validateRegistration(String studentIdStr, String courseIdStr, String registrationDate,
			String status) {
		if (studentIdStr == null || studentIdStr.trim().isEmpty())
			return "Please select a student from the dropdown.";
		try {
			int sid = Integer.parseInt(studentIdStr.trim());
			if (sid <= 0)
				return "Please select a valid student.";
		} catch (NumberFormatException e) {
			return "Invalid student selection.";
		}

		if (courseIdStr == null || courseIdStr.trim().isEmpty())
			return "Please select a course from the dropdown.";
		try {
			int cid = Integer.parseInt(courseIdStr.trim());
			if (cid <= 0)
				return "Please select a valid course.";
		} catch (NumberFormatException e) {
			return "Invalid course selection.";
		}

		if (registrationDate == null || registrationDate.trim().isEmpty())
			return "Registration date is required.";

		LocalDate enteredDate;
		try {
			enteredDate = LocalDate.parse(registrationDate.trim());
		} catch (DateTimeParseException e) {
			return "Invalid date format. Please use the date picker.";
		}

		LocalDate today = LocalDate.now();
		LocalDate minAllowed = today.minusYears(1);

		if (enteredDate.isAfter(today))
			return "Registration date cannot be a future date. Today is " + today + ". You entered: " + enteredDate
					+ ".";

		if (enteredDate.isBefore(minAllowed))
			return "Registration date cannot be more than 1 year in the past. " + "Earliest allowed: " + minAllowed
					+ ". You entered: " + enteredDate + ".";

		if (status == null || status.trim().isEmpty())
			return "Please select a status (Active, Completed, or Cancelled).";
		if (!"Active".equals(status) && !"Completed".equals(status) && !"Cancelled".equals(status))
			return "Status must be Active, Completed, or Cancelled.";

		return null;
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}