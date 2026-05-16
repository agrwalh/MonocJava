<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Add New Course</h2>
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

			<form action="${pageContext.request.contextPath}/course/add"
				method="post">
				<label>Course Name</label> <input type="text" name="courseName"
					placeholder="e.g. Java Full Stack"
					value="<%=request.getAttribute("courseName") != null ? request.getAttribute("courseName") : ""%>">

				<label>Duration</label> <input type="text" name="duration"
					placeholder="e.g. 3 Months"
					value="<%=request.getAttribute("duration") != null ? request.getAttribute("duration") : ""%>">

				<label>Fees (must be greater than 0)</label> <input type="number"
					name="fees" placeholder="e.g. 15000" step="0.01"
					value="<%=request.getAttribute("fees") != null ? request.getAttribute("fees") : ""%>">

				<label>Trainer Name</label> <input type="text" name="trainerName"
					placeholder="e.g. Mr. Ramesh Kumar"
					value="<%=request.getAttribute("trainerName") != null ? request.getAttribute("trainerName") : ""%>">

				<button class="btn-submit" type="submit">Add Course</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/courses">&#8592; Back</a>
			</form>
		</div>
	</div>
</body>
</html>