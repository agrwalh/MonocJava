package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registration/delete")
public class DeleteRegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isLoggedIn(req)) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String idParam = req.getParameter("id");
		if (idParam == null || idParam.trim().isEmpty()) {
			req.setAttribute("registrationList", new RegistrationDAO().getAllRegistrations());
			req.setAttribute("errorMsg", "No registration ID provided.");
			req.getRequestDispatcher("/WEB-INF/views/registration-list.jsp").forward(req, resp);
			return;
		}

		int registrationId;
		try {
			registrationId = Integer.parseInt(idParam.trim());
		} catch (NumberFormatException e) {
			req.setAttribute("registrationList", new RegistrationDAO().getAllRegistrations());
			req.setAttribute("errorMsg", "Invalid registration ID.");
			req.getRequestDispatcher("/WEB-INF/views/registration-list.jsp").forward(req, resp);
			return;
		}

		new RegistrationDAO().deleteRegistration(registrationId);
		resp.sendRedirect(req.getContextPath() + "/registrations");
	}

	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("loggedInUser") != null;
	}
}