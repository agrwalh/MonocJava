<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<div class="welcome-box">
			<h3>
				Welcome,
				<%=session.getAttribute("loggedInUser")%>!
			</h3>
			<p>Here is a quick summary of the system.</p>
		</div>

		<h2>Dashboard</h2>
		<div class="card-row">
			<div class="card">
				<div class="card-number">${totalStudents}</div>
				<div class="card-label">Total Students</div>
			</div>
			<div class="card">
				<div class="card-number">${totalCourses}</div>
				<div class="card-label">Total Courses</div>
			</div>
			<div class="card">
				<div class="card-number">${totalRegistrations}</div>
				<div class="card-label">Total Registrations</div>
			</div>
		</div>

		<h2>Quick Navigation</h2>
		<div class="quick-links">
			<a href="${pageContext.request.contextPath}/students">View
				Students</a> <a href="${pageContext.request.contextPath}/student/add">Add
				Student</a> <a href="${pageContext.request.contextPath}/courses">View
				Courses</a> <a href="${pageContext.request.contextPath}/course/add">Add
				Course</a> <a href="${pageContext.request.contextPath}/registrations">View
				Registrations</a> <a
				href="${pageContext.request.contextPath}/registration/add">Register
				Student</a>
		</div>
	</div>
</body>
</html>