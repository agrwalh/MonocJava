package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.AdminDAO;
import com.studentcourse.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-action")
public class LoginServlet extends HttpServlet {

	@Override
	public void init() {
		System.out.println("[LoginServlet] init() called");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("[LoginServlet] doPost() called");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("rememberMe");

		if (username == null || username.trim().isEmpty()) {
			req.setAttribute("errorMsg", "Username cannot be empty.");
			req.setAttribute("rememberedUsername", "");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			return;
		}
		if (password == null || password.trim().isEmpty()) {
			req.setAttribute("errorMsg", "Password cannot be empty.");
			req.setAttribute("rememberedUsername", username.trim());
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			return;
		}
		if (username.trim().length() < 3) {
			req.setAttribute("errorMsg", "Username must be at least 3 characters.");
			req.setAttribute("rememberedUsername", username.trim());
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			return;
		}
		if (password.trim().length() < 6) {
			req.setAttribute("errorMsg", "Password must be at least 6 characters.");
			req.setAttribute("rememberedUsername", username.trim());
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			return;
		}

		AdminDAO adminDAO = new AdminDAO();
		Admin admin = adminDAO.validateLogin(username.trim(), password.trim());

		if (admin != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInUser", admin.getUsername());
			session.setAttribute("loginTime", new java.util.Date().toString());

			if ("on".equals(rememberMe)) {
				Cookie c = new Cookie("rememberedUsername", admin.getUsername());
				c.setMaxAge(7 * 24 * 60 * 60);
				resp.addCookie(c);
			} else {
				Cookie c = new Cookie("rememberedUsername", "");
				c.setMaxAge(0);
				resp.addCookie(c);
			}
			resp.sendRedirect(req.getContextPath() + "/dashboard");
		} else {
			req.setAttribute("errorMsg", "Invalid username or password. Please try again.");
			req.setAttribute("rememberedUsername", username.trim());
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}

	@Override
	public void destroy() {
		System.out.println("[LoginServlet] destroy() called");
	}
}