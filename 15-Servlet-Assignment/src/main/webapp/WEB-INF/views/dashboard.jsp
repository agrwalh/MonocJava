<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
			<p>
				Logged in as Administrator &nbsp;|&nbsp; Login Time:
				<%=session.getAttribute("loginTime")%></p>
		</div>
		<h2>Dashboard Overview</h2>
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
		<h2>Quick Actions</h2>
		<div class="quick-links">
			<a href="${pageContext.request.contextPath}/students">&#128100;
				View Students</a> <a
				href="${pageContext.request.contextPath}/student/add">&#10133;
				Add Student</a> <a href="${pageContext.request.contextPath}/courses">&#128218;
				View Courses</a> <a href="${pageContext.request.contextPath}/course/add">&#10133;
				Add Course</a> <a
				href="${pageContext.request.contextPath}/registrations">&#128196;
				View Registrations</a> <a
				href="${pageContext.request.contextPath}/registration/add">&#10133;
				Register Student</a>
		</div>
	</div>
</body>
</html>