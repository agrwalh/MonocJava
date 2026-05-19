<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Registration"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Registrations</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<h2>All Registrations</h2>
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
				<span>Registration Records</span> <a class="btn-add"
					href="${pageContext.request.contextPath}/registration/add">+
					Register Student</a>
			</div>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Student Name</th>
						<th>Course Name</th>
						<th>Reg. Date</th>
						<th>Status</th>
						<th>Update Status</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Registration> regList = (List<Registration>) request.getAttribute("registrationList");
					if (regList != null && !regList.isEmpty()) {
						for (Registration r : regList) {
							String badgeClass = "badge-active";
							if ("Completed".equals(r.getStatus()))
						badgeClass = "badge-completed";
							if ("Cancelled".equals(r.getStatus()))
						badgeClass = "badge-cancelled";
					%>
					<tr>
						<td><%=r.getRegistrationId()%></td>
						<td><%=r.getStudentName()%></td>
						<td><%=r.getCourseName()%></td>
						<td><%=r.getRegistrationDate()%></td>
						<td><span class="badge <%=badgeClass%>"><%=r.getStatus()%></span></td>
						<td>
							<%-- NOTE: select name is "regStatus" (not "status") to avoid JS window.status conflict --%>
							<form class="status-form"
								action="${pageContext.request.contextPath}/registration/status"
								method="post" onsubmit="return confirmChange(this)">
								<input type="hidden" name="registrationId"
									value="<%=r.getRegistrationId()%>"> <select
									name="regStatus" id="sel_<%=r.getRegistrationId()%>">
									<option value="Active"
										<%="Active".equals(r.getStatus()) ? "selected" : ""%>>Active</option>
									<option value="Completed"
										<%="Completed".equals(r.getStatus()) ? "selected" : ""%>>Completed</option>
									<option value="Cancelled"
										<%="Cancelled".equals(r.getStatus()) ? "selected" : ""%>>Cancelled</option>
								</select>
								<button type="submit">Save</button>
							</form>
						</td>
						<td><a class="btn-delete"
							href="${pageContext.request.contextPath}/registration/delete?id=<%= r.getRegistrationId() %>"
							onclick="return confirm('Delete registration for <%= r.getStudentName() %> - <%= r.getCourseName() %>?')">
								&#128465; Delete </a></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="7"
							style="text-align: center; padding: 22px; color: #888;">No
							registrations found. <a
							href="${pageContext.request.contextPath}/registration/add">Register
								a student now.</a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		function confirmChange(form) {
			// Get selected value from the regStatus select inside this form
			var sel = form.querySelector('select[name="regStatus"]');
			var selectedValue = sel.options[sel.selectedIndex].value;
			return confirm('Change registration status to: ' + selectedValue
					+ '?');
		}
	</script>

</body>
</html>