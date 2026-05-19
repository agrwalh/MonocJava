<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Edit Student Details</h2>
		<div class="form-box">
			<%
			String errorMsg = (String) request.getAttribute("errorMsg");
			Student s = (Student) request.getAttribute("student");
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
			<form action="${pageContext.request.contextPath}/student/update"
				method="post" onsubmit="return validateStudentForm()">
				<input type="hidden" name="studentId"
					value="<%=s.getStudentId()%>">
				<div class="form-group">
					<label>Student Name <span style="color: #c62828">*</span></label> <input
						type="text" id="sName" name="studentName"
						value="<%=s.getStudentName()%>" maxlength="100"> <small>Letters
						and spaces only</small>
				</div>
				<div class="form-group">
					<label>Email Address <span style="color: #c62828">*</span></label>
					<input type="text" id="sEmail" name="email"
						value="<%=s.getEmail()%>" maxlength="100">
				</div>
				<div class="form-group">
					<label>Phone Number <span style="color: #c62828">*</span></label> <input
						type="text" id="sPhone" name="phone" value="<%=s.getPhone()%>"
						maxlength="10"> <small>Exactly 10 digits, should
						not start with 0</small>
				</div>
				<div class="form-group">
					<label>Age <span style="color: #c62828">*</span></label> <input
						type="number" id="sAge" name="age" value="<%=s.getAge()%>"
						min="18" max="100"> <small>Must be 18 or above</small>
				</div>
				<div class="form-group">
					<label>City <span style="color: #c62828">*</span></label> <input
						type="text" id="sCity" name="city" value="<%=s.getCity()%>"
						maxlength="50">
				</div>
				<div id="clientError" class="alert-error" style="display: none;"></div>
				<button class="btn-submit" type="submit">Update Student</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/students">&#8592; Back
					to List</a>
			</form>
		</div>
	</div>
	<script>
		function validateStudentForm() {
			var name = document.getElementById('sName').value.trim();
			var email = document.getElementById('sEmail').value.trim();
			var phone = document.getElementById('sPhone').value.trim();
			var age = document.getElementById('sAge').value.trim();
			var city = document.getElementById('sCity').value.trim();
			var err = document.getElementById('clientError');
			err.style.display = 'none';
			function showErr(msg) {
				err.textContent = '\u26A0 ' + msg;
				err.style.display = 'block';
			}
			if (name === '') {
				showErr('Student name is required.');
				return false;
			}
			if (name.length < 2) {
				showErr('Name must be at least 2 characters.');
				return false;
			}
			if (!/^[a-zA-Z\s]+$/.test(name)) {
				showErr('Name must contain letters only.');
				return false;
			}
			if (email === '') {
				showErr('Email is required.');
				return false;
			}
			if (!/^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email)) {
				showErr('Please enter a valid email address.');
				return false;
			}
			if (phone === '') {
				showErr('Phone number is required.');
				return false;
			}
			if (!/^\d{10}$/.test(phone)) {
				showErr('Phone must be exactly 10 digits.');
				return false;
			}
			if (phone.charAt(0) === '0') {
				showErr('Phone should not start with 0.');
				return false;
			}
			if (age === '') {
				showErr('Age is required.');
				return false;
			}
			var ageNum = parseInt(age, 10);
			if (isNaN(ageNum) || ageNum < 18) {
				showErr('Age must be 18 or above.');
				return false;
			}
			if (ageNum > 100) {
				showErr('Please enter a realistic age (max 100).');
				return false;
			}
			if (city === '') {
				showErr('City is required.');
				return false;
			}
			if (!/^[a-zA-Z\s]+$/.test(city)) {
				showErr('City must contain letters only.');
				return false;
			}
			return true;
		}
	</script>
</body>
</html>