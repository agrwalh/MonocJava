<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Registration"%>
<!DOCTYPE html>
<html>
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
		<div class="table-box">
			<div class="table-top">
				<span><strong>Registration Records</strong></span> <a
					class="btn-add"
					href="${pageContext.request.contextPath}/registration/add">+
					Register Student</a>
			</div>
			<table>
				<tr>
					<th>ID</th>
					<th>Student</th>
					<th>Course</th>
					<th>Date</th>
					<th>Status</th>
					<th>Update Status</th>
					<th>Delete</th>
				</tr>
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
						<form class="status-form"
							action="${pageContext.request.contextPath}/registration/status"
							method="post" style="display: inline;">
							<input type="hidden" name="registrationId"
								value="<%=r.getRegistrationId()%>"> <select
								name="status">
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
						onclick="return confirm('Delete this registration?')">Delete</a></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="7"
						style="text-align: center; color: #888; padding: 20px;">No
						registrations found.</td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>