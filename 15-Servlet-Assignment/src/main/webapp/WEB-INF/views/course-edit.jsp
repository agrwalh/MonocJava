<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Course"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Edit Course Details</h2>
		<div class="form-box">
			<%
			String errorMsg = (String) request.getAttribute("errorMsg");
			Course c = (Course) request.getAttribute("course");
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
			<form action="${pageContext.request.contextPath}/course/update"
				method="post" onsubmit="return validateCourseForm()">
				<input type="hidden" name="courseId" value="<%=c.getCourseId()%>">
				<div class="form-group">
					<label>Course Name <span style="color: #c62828">*</span></label> <input
						type="text" id="cName" name="courseName"
						value="<%=c.getCourseName()%>" maxlength="100">
				</div>
				<div class="form-group">
					<label>Duration <span style="color: #c62828">*</span></label> <input
						type="text" id="cDuration" name="duration"
						value="<%=c.getDuration()%>" maxlength="50">
				</div>
				<div class="form-group">
					<label>Fees (&#8377;) <span style="color: #c62828">*</span></label>
					<input type="number" id="cFees" name="fees"
						value="<%=c.getFees()%>" step="0.01" min="1"> <small>Must
						be greater than 0</small>
				</div>
				<div class="form-group">
					<label>Trainer Name <span style="color: #c62828">*</span></label> <input
						type="text" id="cTrainer" name="trainerName"
						value="<%=c.getTrainerName()%>" maxlength="100">
				</div>
				<div id="clientError" class="alert-error" style="display: none;"></div>
				<button class="btn-submit" type="submit">Update Course</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/courses">&#8592; Back
					to List</a>
			</form>
		</div>
	</div>
	<script>
		function validateCourseForm() {
			var name = document.getElementById('cName').value.trim();
			var dur = document.getElementById('cDuration').value.trim();
			var fees = document.getElementById('cFees').value.trim();
			var trnr = document.getElementById('cTrainer').value.trim();
			var err = document.getElementById('clientError');
			err.style.display = 'none';
			function showErr(msg) {
				err.textContent = '\u26A0 ' + msg;
				err.style.display = 'block';
			}
			if (name === '') {
				showErr('Course name is required.');
				return false;
			}
			if (name.length < 3) {
				showErr('Course name must be at least 3 characters.');
				return false;
			}
			if (dur === '') {
				showErr('Duration is required.');
				return false;
			}
			if (fees === '') {
				showErr('Fees are required.');
				return false;
			}
			var f = parseFloat(fees);
			if (isNaN(f) || f <= 0) {
				showErr('Fees must be a number greater than 0.');
				return false;
			}
			var parts = fees.split('.');
			if (parts.length === 2 && parts[1].length > 2) {
				showErr('Fees: max 2 decimal places.');
				return false;
			}
			if (trnr === '') {
				showErr('Trainer name is required.');
				return false;
			}
			if (!/^[a-zA-Z\s.]+$/.test(trnr)) {
				showErr('Trainer name must contain letters only.');
				return false;
			}
			return true;
		}
	</script>
</body>
</html>