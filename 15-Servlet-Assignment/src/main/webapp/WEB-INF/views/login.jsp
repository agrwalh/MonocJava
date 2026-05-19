<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
			<span class="subtitle">Student Course Registration &amp;
				Management System</span>

			<%
			String errorMsg = (String) request.getAttribute("errorMsg");
			String remembered = (String) request.getAttribute("rememberedUsername");
			if (remembered == null)
				remembered = "";
			%>
			<%
			if (errorMsg != null && !errorMsg.isEmpty()) {
			%>
			<div class="alert-error">
				&#9888;
				<%=errorMsg%></div>
			<%
			}
			%>

			<form action="${pageContext.request.contextPath}/login-action"
				method="post" onsubmit="return validateLoginForm()">

				<label for="username">Username <span style="color: #c62828">*</span></label>
				<input type="text" id="username" name="username"
					value="<%=remembered%>" placeholder="Enter your username"
					maxlength="50"> <label for="password">Password <span
					style="color: #c62828">*</span></label> <input type="password"
					id="password" name="password" placeholder="Enter your password"
					maxlength="100">

				<div class="remember-row">
					<input type="checkbox" id="rememberMe" name="rememberMe"
						<%=(remembered != null && !remembered.isEmpty()) ? "checked" : ""%>>
					<label for="rememberMe"
						style="font-weight: normal; cursor: pointer;"> Remember my
						username </label>
				</div>

				<div id="clientError" class="alert-error" style="display: none;"></div>
				<button type="submit">Login</button>
			</form>
		</div>
	</div>
	<script>
		function validateLoginForm() {
			var u = document.getElementById('username').value.trim();
			var p = document.getElementById('password').value.trim();
			var err = document.getElementById('clientError');
			err.style.display = 'none';
			function showErr(msg) {
				err.textContent = '\u26A0 ' + msg;
				err.style.display = 'block';
			}
			if (u === '') {
				showErr('Username cannot be empty.');
				return false;
			}
			if (u.length < 3) {
				showErr('Username must be at least 3 characters.');
				return false;
			}
			if (p === '') {
				showErr('Password cannot be empty.');
				return false;
			}
			if (p.length < 6) {
				showErr('Password must be at least 6 characters.');
				return false;
			}
			return true;
		}
	</script>
</body>
</html>