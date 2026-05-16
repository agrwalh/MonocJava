<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Edit Student</h2>
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

			<%
			Student s = (Student) request.getAttribute("student");
			%>
			<form action="${pageContext.request.contextPath}/student/update"
				method="post">
				<input type="hidden" name="studentId"
					value="<%=s.getStudentId()%>"> <label>Student
					Name</label> <input type="text" name="studentName"
					value="<%=s.getStudentName()%>"> <label>Email</label> <input
					type="text" name="email" value="<%=s.getEmail()%>"> <label>Phone</label>
				<input type="text" name="phone" value="<%=s.getPhone()%>">

				<label>Age</label> <input type="number" name="age"
					value="<%=s.getAge()%>"> <label>City</label> <input
					type="text" name="city" value="<%=s.getCity()%>">

				<button class="btn-submit" type="submit">Update Student</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/students">&#8592; Back</a>
			</form>
		</div>
	</div>
</body>
</html>