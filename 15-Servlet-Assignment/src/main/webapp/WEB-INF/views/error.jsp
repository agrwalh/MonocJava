<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Something Went Wrong</h2>
		<div class="form-box">
			<div class="alert-error">
				&#9888;
				<%
				String msg = (String) request.getAttribute("errorMsg");
				out.print(msg != null ? msg : "An unexpected error occurred. Please try again.");
				%>
			</div>
			<br> <a class="back-link"
				href="${pageContext.request.contextPath}/dashboard">&#8592; Go
				to Dashboard</a>
		</div>
	</div>
</body>
</html>