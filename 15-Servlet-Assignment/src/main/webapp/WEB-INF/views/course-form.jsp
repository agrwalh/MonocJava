<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
			String errorMsg = (String) request.getAttribute("errorMsg");
			String courseName = (String) request.getAttribute("courseName");
			String duration = (String) request.getAttribute("duration");
			String fees = (String) request.getAttribute("fees");
			String trainerName = (String) request.getAttribute("trainerName");
			if (courseName == null)
				courseName = "";
			if (duration == null)
				duration = "";
			if (fees == null)
				fees = "";
			if (trainerName == null)
				trainerName = "";
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
			<form action="${pageContext.request.contextPath}/course/add"
				method="post" onsubmit="return validateCourseForm()">
				<div class="form-group">
					<label>Course Name <span style="color: #c62828">*</span></label> <input
						type="text" id="cName" name="courseName" value="<%=courseName%>"
						placeholder="e.g. Java Full Stack Development" maxlength="100">
					<small>Minimum 3 characters</small>
				</div>
				<div class="form-group">
					<label>Duration <span style="color: #c62828">*</span></label> <input
						type="text" id="cDuration" name="duration" value="<%=duration%>"
						placeholder="e.g. 3 Months or 12 Weeks" maxlength="50">
				</div>
				<div class="form-group">
					<label>Fees (&#8377;) <span style="color: #c62828">*</span></label>
					<input type="number" id="cFees" name="fees" value="<%=fees%>"
						placeholder="e.g. 15000" step="0.01" min="1"> <small>Must
						be greater than 0. Max 2 decimal places allowed.</small>
				</div>
				<div class="form-group">
					<label>Trainer Name <span style="color: #c62828">*</span></label> <input
						type="text" id="cTrainer" name="trainerName"
						value="<%=trainerName%>" placeholder="e.g. Mr. Ramesh Kumar"
						maxlength="100"> <small>Letters and dots only (Mr.
						/ Ms. allowed)</small>
				</div>
				<div id="clientError" class="alert-error" style="display: none;"></div>
				<button class="btn-submit" type="submit">Add Course</button>
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
			var trainer = document.getElementById('cTrainer').value.trim();
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
				showErr('Duration is required (e.g. 3 Months).');
				return false;
			}
			if (fees === '') {
				showErr('Fees are required.');
				return false;
			}
			var f = parseFloat(fees);
			if (isNaN(f)) {
				showErr('Fees must be a valid number.');
				return false;
			}
			if (f <= 0) {
				showErr('Fees must be greater than 0.');
				return false;
			}
			var parts = fees.split('.');
			if (parts.length === 2 && parts[1].length > 2) {
				showErr('Fees can have at most 2 decimal places.');
				return false;
			}
			if (trainer === '') {
				showErr('Trainer name is required.');
				return false;
			}
			if (trainer.length < 2) {
				showErr('Trainer name must be at least 2 characters.');
				return false;
			}
			if (!/^[a-zA-Z\s.]+$/.test(trainer)) {
				showErr('Trainer name must contain letters only (dots allowed for Mr./Ms.).');
				return false;
			}
			return true;
		}
	</script>
</body>
</html>