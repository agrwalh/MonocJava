<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Add New Student</h2>
		<div class="form-box">
			<%
			String errorMsg = (String) request.getAttribute("errorMsg");
			String studentName = (String) request.getAttribute("studentName");
			String email = (String) request.getAttribute("email");
			String phone = (String) request.getAttribute("phone");
			String age = (String) request.getAttribute("age");
			String city = (String) request.getAttribute("city");
			if (studentName == null)
				studentName = "";
			if (email == null)
				email = "";
			if (phone == null)
				phone = "";
			if (age == null)
				age = "";
			if (city == null)
				city = "";
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

			<form action="${pageContext.request.contextPath}/student/add"
				method="post" onsubmit="return validateStudentForm()">

				<div class="form-group">
					<label>Student Name <span style="color: #c62828">*</span></label> <input
						type="text" id="sName" name="studentName"
						value="<%=studentName%>" placeholder="e.g. Rahul Sharma"
						maxlength="100">
				</div>
				<div class="form-group">
					<label>Email Address <span style="color: #c62828">*</span></label>
					<input type="text" id="sEmail" name="email" value="<%=email%>"
						placeholder="e.g. rahul@gmail.com" maxlength="100">
				</div>
				<div class="form-group">
					<label>Phone Number <span style="color: #c62828">*</span></label> <input
						type="text" id="sPhone" name="phone" value="<%=phone%>"
						placeholder="e.g. 9876543210" maxlength="10">
				</div>
				<div class="form-group">
					<label>Age <span style="color: #c62828">*</span></label> <input
						type="number" id="sAge" name="age" value="<%=age%>"
						placeholder="e.g. 20" min="18" max="100">
				</div>
				<div class="form-group">
					<label>City <span style="color: #c62828">*</span></label> <input
						type="text" id="sCity" name="city" value="<%=city%>"
						placeholder="e.g. Delhi" maxlength="50">
				</div>

				<div id="clientError" class="alert-error" style="display: none;"></div>
				<button class="btn-submit" type="submit">Add Student</button>
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
				showErr('Name must contain letters only (no numbers or symbols).');
				return false;
			}
			if (email === '') {
				showErr('Email is required.');
				return false;
			}
			if (!/^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email)) {
				showErr('Please enter a valid email (e.g. rahul@gmail.com).');
				return false;
			}
			if (phone === '') {
				showErr('Phone number is required.');
				return false;
			}
			if (!/^\d{10}$/.test(phone)) {
				showErr('Phone must be exactly 10 digits (numbers only).');
				return false;
			}
			if (phone.charAt(0) === '0') {
				showErr('Phone number should not start with 0.');
				return false;
			}
			if (age === '') {
				showErr('Age is required.');
				return false;
			}
			var ageNum = parseInt(age, 10);
			if (isNaN(ageNum)) {
				showErr('Age must be a valid number.');
				return false;
			}
			if (ageNum < 18) {
				showErr('Age must be 18 or above. You entered: ' + ageNum + '.');
				return false;
			}
			if (ageNum > 100) {
				showErr('Please enter a realistic age (18 to 100).');
				return false;
			}
			if (city === '') {
				showErr('City is required.');
				return false;
			}
			if (!/^[a-zA-Z\s]+$/.test(city)) {
				showErr('City name must contain letters only.');
				return false;
			}
			return true;
		}
	</script>
</body>
</html>