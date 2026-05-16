<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>All Courses</h2>

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

		<div class="table-box">
			<div class="table-top">
				<span><strong>Course Records</strong></span> <a class="btn-add"
					href="${pageContext.request.contextPath}/course/add">+ Add
					Course</a>
			</div>
			<table>
				<tr>
					<th>ID</th>
					<th>Course Name</th>
					<th>Duration</th>
					<th>Fees</th>
					<th>Trainer</th>
					<th>Actions</th>
				</tr>
				<%
				List<Course> list = (List<Course>) request.getAttribute("courseList");
				if (list != null && !list.isEmpty()) {
					for (Course c : list) {
				%>
				<tr>
					<td><%=c.getCourseId()%></td>
					<td><%=c.getCourseName()%></td>
					<td><%=c.getDuration()%></td>
					<td>&#8377; <%=c.getFees()%></td>
					<td><%=c.getTrainerName()%></td>
					<td><a class="btn-edit"
						href="${pageContext.request.contextPath}/course/edit?id=<%= c.getCourseId() %>">Edit</a>
						<a class="btn-delete"
						href="${pageContext.request.contextPath}/course/delete?id=<%= c.getCourseId() %>"
						onclick="return confirm('Delete this course?')">Delete</a></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="6"
						style="text-align: center; color: #888; padding: 20px;">No
						courses found.</td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>