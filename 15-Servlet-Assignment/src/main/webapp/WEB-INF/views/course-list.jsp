<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Course"%>
<!DOCTYPE html>
<html lang="en">
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
		String errorMsg = (String) request.getAttribute("errorMsg");
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
		<div class="table-box">
			<div class="table-top">
				<span>Course Records</span> <a class="btn-add"
					href="${pageContext.request.contextPath}/course/add">+ Add New
					Course</a>
			</div>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Course Name</th>
						<th>Duration</th>
						<th>Fees (&#8377;)</th>
						<th>Trainer</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Course> list = (List<Course>) request.getAttribute("courseList");
					if (list != null && !list.isEmpty()) {
						for (Course c : list) {
					%>
					<tr>
						<td><%=c.getCourseId()%></td>
						<td><%=c.getCourseName()%></td>
						<td><%=c.getDuration()%></td>
						<td>&#8377; <%=String.format("%.2f", c.getFees())%></td>
						<td><%=c.getTrainerName()%></td>
						<td><a class="btn-edit"
							href="${pageContext.request.contextPath}/course/edit?id=<%= c.getCourseId() %>">&#9998;
								Edit</a> <a class="btn-delete"
							href="${pageContext.request.contextPath}/course/delete?id=<%= c.getCourseId() %>"
							onclick="return confirm('Delete course: <%= c.getCourseName() %>?\n\nNote: Cannot delete if students are actively registered.')">
								&#128465; Delete </a></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="6"
							style="text-align: center; padding: 22px; color: #888;">No
							courses found. <a
							href="${pageContext.request.contextPath}/course/add">Add one
								now.</a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>