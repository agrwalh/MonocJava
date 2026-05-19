package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registration/status")
public class UpdateRegistrationStatusServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idStr = req.getParameter("registrationId");
		// Read "regStatus" — not "status" — to avoid JavaScript window.status conflict
		String status = req.getParameter("regStatus");

		// --- Validate ID ---
		if (idStr == null || idStr.trim().isEmpty()) {
			req.setAttribute("registrationList", new RegistrationDAO().getAllRegistrations());
			req.setAttribute("errorMsg", "Registration ID is missing.");
			req.getRequestDispatcher("/WEB-INF/views/registration-list.jsp").forward(req, resp);
			return;
		}

		int registrationId;
		try {
			registrationId = Integer.parseInt(idStr.trim());
			if (registrationId <= 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			req.setAttribute("registrationList", new RegistrationDAO().getAllRegistrations());
			req.setAttribute("errorMsg", "Invalid registration ID.");
			req.getRequestDispatcher("/WEB-INF/views/registration-list.jsp").forward(req, resp);
			return;
		}

		// --- Validate Status ---
		if (status == null || status.trim().isEmpty()) {
			req.setAttribute("registrationList", new RegistrationDAO().getAllRegistrations());
			req.setAttribute("errorMsg", "Please select a valid status.");
			req.getRequestDispatcher("/WEB-INF/views/registration-list.jsp").forward(req, resp);
			return;
		}

		status = status.trim();

		if (!"Active".equals(status) && !"Completed".equals(status) && !"Cancelled".equals(status)) {
			req.setAttribute("registrationList", new RegistrationDAO().getAllRegistrations());
			req.setAttribute("errorMsg", "Status must be Active, Completed, or Cancelled. Received: " + status);
			req.getRequestDispatcher("/WEB-INF/views/registration-list.jsp").forward(req, resp);
			return;
		}

		// --- Update in DB ---
		new RegistrationDAO().updateStatus(registrationId, status);
		resp.sendRedirect(req.getContextPath() + "/registrations");
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}