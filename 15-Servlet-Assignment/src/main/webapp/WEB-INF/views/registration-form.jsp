<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.studentcourse.model.Student, com.studentcourse.model.Course"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register Student</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>Register Student for a Course</h2>
		<div class="form-box">
			<%
			String errorMsg = (String) request.getAttribute("errorMsg");
			String todayDate = (String) request.getAttribute("todayDate");
			String selStudId = (String) request.getAttribute("selStudentId");
			String selCourseId = (String) request.getAttribute("selCourseId");
			String selDate = (String) request.getAttribute("selDate");
			String selStatus = (String) request.getAttribute("selStatus");
			if (todayDate == null)
				todayDate = java.time.LocalDate.now().toString();
			if (selStudId == null)
				selStudId = "";
			if (selCourseId == null)
				selCourseId = "";
			if (selDate == null)
				selDate = "";
			if (selStatus == null)
				selStatus = "";
			String minDate = java.time.LocalDate.now().minusYears(1).toString();
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

			<div
				style="background: #e3f2fd; border: 1px solid #90caf9; border-radius: 5px; padding: 10px 14px; margin-bottom: 16px; font-size: 13px; color: #0d47a1;">
				&#8505; Registration date must be <strong>today or earlier</strong>
				(no future dates). Back-dating allowed up to <strong>1 year</strong>
				only.
			</div>

			<form action="${pageContext.request.contextPath}/registration/add"
				method="post" onsubmit="return validateRegForm()">

				<div class="form-group">
					<label>Select Student <span style="color: #c62828">*</span></label>
					<select id="rStudent" name="studentId">
						<option value="">-- Select a Student --</option>
						<%
						List<Student> studentList = (List<Student>) request.getAttribute("studentList");
						if (studentList != null) {
							for (Student s : studentList) {
								boolean selected = String.valueOf(s.getStudentId()).equals(selStudId);
						%>
						<option value="<%=s.getStudentId()%>"
							<%=selected ? "selected" : ""%>>
							<%=s.getStudentName()%> (ID:
							<%=s.getStudentId()%>)
						</option>
						<%
						}
						}
						%>
					</select>
				</div>

				<div class="form-group">
					<label>Select Course <span style="color: #c62828">*</span></label>
					<select id="rCourse" name="courseId">
						<option value="">-- Select a Course --</option>
						<%
						List<Course> courseList = (List<Course>) request.getAttribute("courseList");
						if (courseList != null) {
							for (Course c : courseList) {
								boolean selected = String.valueOf(c.getCourseId()).equals(selCourseId);
						%>
						<option value="<%=c.getCourseId()%>"
							<%=selected ? "selected" : ""%>>
							<%=c.getCourseName()%> (&#8377;<%=String.format("%.0f", c.getFees())%>)
						</option>
						<%
						}
						}
						%>
					</select>
				</div>

				<div class="form-group">
					<label>Registration Date <span style="color: #c62828">*</span></label>
					<input type="date" id="rDate" name="registrationDate"
						value="<%=selDate%>" max="<%=todayDate%>" min="<%=minDate%>">
					<small>Cannot be a future date. Max 1 year back-dating
						allowed.</small>
				</div>

				<div class="form-group">
					<label>Status <span style="color: #c62828">*</span></label> <select
						id="rStatus" name="status">
						<option value="">-- Select Status --</option>
						<option value="Active"
							<%="Active".equals(selStatus) ? "selected" : ""%>>Active</option>
						<option value="Completed"
							<%="Completed".equals(selStatus) ? "selected" : ""%>>Completed</option>
						<option value="Cancelled"
							<%="Cancelled".equals(selStatus) ? "selected" : ""%>>Cancelled</option>
					</select>
				</div>

				<div id="clientError" class="alert-error" style="display: none;"></div>
				<button class="btn-submit" type="submit">Register Student</button>
				<a class="back-link"
					href="${pageContext.request.contextPath}/registrations">&#8592;
					Back to List</a>
			</form>
		</div>
	</div>
	<script>
		function validateRegForm() {
			var student = document.getElementById('rStudent').value.trim();
			var course = document.getElementById('rCourse').value.trim();
			var date = document.getElementById('rDate').value.trim();
			var status = document.getElementById('rStatus').value.trim();
			var err = document.getElementById('clientError');
			err.style.display = 'none';
			function showErr(msg) {
				err.textContent = '\u26A0 ' + msg;
				err.style.display = 'block';
			}

			if (student === '' || student === '0') {
				showErr('Please select a student.');
				return false;
			}
			if (course === '' || course === '0') {
				showErr('Please select a course.');
				return false;
			}
			if (date === '') {
				showErr('Registration date is required.');
				return false;
			}

			var entered = new Date(date);
			var today = new Date();
			today.setHours(0, 0, 0, 0);
			var oneYearAgo = new Date();
			oneYearAgo.setFullYear(oneYearAgo.getFullYear() - 1);
			oneYearAgo.setHours(0, 0, 0, 0);

			if (entered > today) {
				showErr('Registration date cannot be a future date. Today is '
						+ today.toISOString().slice(0, 10) + '. You entered: '
						+ date + '.');
				return false;
			}
			if (entered < oneYearAgo) {
				showErr('Registration date cannot be more than 1 year in the past. Earliest allowed: '
						+ oneYearAgo.toISOString().slice(0, 10) + '.');
				return false;
			}
			if (status === '') {
				showErr('Please select a status.');
				return false;
			}
			if (status !== 'Active' && status !== 'Completed'
					&& status !== 'Cancelled') {
				showErr('Status must be Active, Completed, or Cancelled.');
				return false;
			}
			return true;
		}
	</script>
</body>
</html>