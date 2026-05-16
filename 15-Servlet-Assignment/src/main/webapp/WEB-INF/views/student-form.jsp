<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Add New Student</h2>
		<div class="form-box">
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

			<form action="${pageContext.request.contextPath}/student/add"
				method="post">
				<label>Student Name</label> <input type="text" name="studentName"
					placeholder="e.g. Rahul Sharma"
					value="<%=request.getAttribute("studentName") != null ? request.getAttribute("studentName") : ""%>">

				<label>Email</label> <input type="text" name="email"
					placeholder="e.g. rahul@email.com"
					value="<%=request.getAttribute("email") != null ? request.getAttribute("email") : ""%>">

				<label>Phone</label> <input type="text" name="phone"
					placeholder="e.g. 9876543210"
					value="<%=request.getAttribute("phone") != null ? request.getAttribute("phone") : ""%>">

				<label>Age (must be 18 or above)</label> <input type="number"
					name="age" placeholder="e.g. 20"
					value="<%=request.getAttribute("age") != null ? request.getAttribute("age") : ""%>">

				<label>City</label> <input type="text" name="city"
					placeholder="e.g. Delhi"
					value="<%=request.getAttribute("city") != null ? request.getAttribute("city") : ""%>">

				<button class="btn-submit" type="submit">Add Student</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/students">&#8592; Back</a>
			</form>
		</div>
	</div>
</body>
</html>