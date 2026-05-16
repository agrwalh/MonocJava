<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>All Students</h2>

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
				<span><strong>Student Records</strong></span> <a class="btn-add"
					href="${pageContext.request.contextPath}/student/add">+ Add
					Student</a>
			</div>
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Age</th>
					<th>City</th>
					<th>Actions</th>
				</tr>
				<%
				List<Student> list = (List<Student>) request.getAttribute("studentList");
				if (list != null && !list.isEmpty()) {
					for (Student s : list) {
				%>
				<tr>
					<td><%=s.getStudentId()%></td>
					<td><%=s.getStudentName()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getPhone()%></td>
					<td><%=s.getAge()%></td>
					<td><%=s.getCity()%></td>
					<td><a class="btn-edit"
						href="${pageContext.request.contextPath}/student/edit?id=<%= s.getStudentId() %>">Edit</a>
						<a class="btn-delete"
						href="${pageContext.request.contextPath}/student/delete?id=<%= s.getStudentId() %>"
						onclick="return confirm('Delete this student?')">Delete</a></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="7"
						style="text-align: center; color: #888; padding: 20px;">No
						students found.</td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>