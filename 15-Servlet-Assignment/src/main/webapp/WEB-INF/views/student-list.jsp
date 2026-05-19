<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Student"%>
<!DOCTYPE html>
<html lang="en">
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
				<span>Student Records</span> <a class="btn-add"
					href="${pageContext.request.contextPath}/student/add">+ Add New
					Student</a>
			</div>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Age</th>
						<th>City</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
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
							href="${pageContext.request.contextPath}/student/edit?id=<%= s.getStudentId() %>">&#9998;
								Edit</a> <a class="btn-delete"
							href="${pageContext.request.contextPath}/student/delete?id=<%= s.getStudentId() %>"
							onclick="return confirm('Delete student: <%= s.getStudentName() %>?\n\nNote: Cannot delete if student is registered in any course.')">
								&#128465; Delete </a></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="7"
							style="text-align: center; padding: 22px; color: #888;">No
							students found. <a
							href="${pageContext.request.contextPath}/student/add">Add one
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