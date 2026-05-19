package com.studentcourse.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {

	@Override
	public void init() {
		System.out.println("[LoginPageServlet] init() called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("loggedInUser") != null) {
			resp.sendRedirect(req.getContextPath() + "/dashboard");
			return;
		}

		String rememberedUsername = "";
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("rememberedUsername".equals(c.getName())) {
					rememberedUsername = c.getValue();
					break;
				}
			}
		}
		req.setAttribute("rememberedUsername", rememberedUsername);
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("[LoginPageServlet] destroy() called");
	}
}