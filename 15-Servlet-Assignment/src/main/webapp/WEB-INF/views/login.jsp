<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="login-wrapper">
		<div class="login-box">
			<h2>Admin Login</h2>
			<p class="subtitle">Student Course Management System</p>

			<%
			String error = (String) request.getAttribute("errorMsg");
			%>
			<%
			if (error != null) {
			%>
			<div class="alert-error"><%=error%></div>
			<%
			}
			%>

			<form action="${pageContext.request.contextPath}/login-action"
				method="post">
				<label for="username">Username</label> <input type="text"
					id="username" name="username"
					value="<%=request.getAttribute("rememberedUsername") != null ? request.getAttribute("rememberedUsername") : ""%>"
					placeholder="Enter username"> <label for="password">Password</label>
				<input type="password" id="password" name="password"
					placeholder="Enter password">

				<div class="remember-row">
					<input type="checkbox" id="rememberMe" name="rememberMe"
						<%=(request.getAttribute("rememberedUsername") != null
		&& !request.getAttribute("rememberedUsername").toString().isEmpty()) ? "checked" : ""%>>
					<label for="rememberMe" style="font-weight: normal;">Remember
						my username</label>
				</div>

				<button type="submit">Login</button>
			</form>
		</div>
	</div>
</body>
</html>