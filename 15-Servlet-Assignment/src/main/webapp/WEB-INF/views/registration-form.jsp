<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.studentcourse.model.Student, com.studentcourse.model.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Register Student for a Course</h2>
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

			<form action="${pageContext.request.contextPath}/registration/add"
				method="post">
				<label>Select Student</label> <select name="studentId">
					<option value="">-- Select a Student --</option>
					<%
					List<Student> studentList = (List<Student>) request.getAttribute("studentList");
					if (studentList != null) {
						for (Student s : studentList) {
					%>
					<option value="<%=s.getStudentId()%>"><%=s.getStudentName()%></option>
					<%
					}
					}
					%>
				</select> <label>Select Course</label> <select name="courseId">
					<option value="">-- Select a Course --</option>
					<%
					List<Course> courseList = (List<Course>) request.getAttribute("courseList");
					if (courseList != null) {
						for (Course c : courseList) {
					%>
					<option value="<%=c.getCourseId()%>"><%=c.getCourseName()%></option>
					<%
					}
					}
					%>
				</select> <label>Registration Date</label> <input type="date"
					name="registrationDate"> <label>Status</label> <select
					name="status">
					<option value="">-- Select Status --</option>
					<option value="Active">Active</option>
					<option value="Completed">Completed</option>
					<option value="Cancelled">Cancelled</option>
				</select>

				<button class="btn-submit" type="submit">Register</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/registrations">&#8592;
					Back</a>
			</form>
		</div>
	</div>
</body>
</html>