package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.AdminDAO;
import com.studentcourse.model.Admin;

import jakarta.servlet.RequestDispatcher;
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
		System.out.println("LoginServlet initialized");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Login form submitted");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("rememberMe");

		if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
			req.setAttribute("errorMsg", "Username and password are required.");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
			return;
		}

		AdminDAO adminDAO = new AdminDAO();
		Admin admin = adminDAO.validateLogin(username.trim(), password.trim());

		if (admin != null) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", admin.getUsername());
			session.setAttribute("loginTime", new java.util.Date().toString());

			if ("on".equals(rememberMe)) {
				Cookie userCookie = new Cookie("rememberedUsername", admin.getUsername());
				userCookie.setMaxAge(7 * 24 * 60 * 60);
				resp.addCookie(userCookie);
			} else {
				Cookie userCookie = new Cookie("rememberedUsername", "");
				userCookie.setMaxAge(0);
				resp.addCookie(userCookie);
			}

			resp.sendRedirect(req.getContextPath() + "/dashboard");
		} else {
			req.setAttribute("errorMsg", "Invalid username or password.");
			req.setAttribute("enteredUsername", username);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	public void destroy() {
		System.out.println("LoginServlet destroyed");
	}
}