<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Edit Course</h2>
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
			Course c = (Course) request.getAttribute("course");
			%>
			<form action="${pageContext.request.contextPath}/course/update"
				method="post">
				<input type="hidden" name="courseId" value="<%=c.getCourseId()%>">

				<label>Course Name</label> <input type="text" name="courseName"
					value="<%=c.getCourseName()%>"> <label>Duration</label> <input
					type="text" name="duration" value="<%=c.getDuration()%>">

				<label>Fees</label> <input type="number" name="fees"
					value="<%=c.getFees()%>" step="0.01"> <label>Trainer
					Name</label> <input type="text" name="trainerName"
					value="<%=c.getTrainerName()%>">

				<button class="btn-submit" type="submit">Update Course</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/courses">&#8592; Back</a>
			</form>
		</div>
	</div>
</body>
</html>