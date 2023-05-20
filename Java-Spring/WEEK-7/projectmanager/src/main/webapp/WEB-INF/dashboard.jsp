<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Welcome, ${nameInSession}!</h1>
			<a href="/logout">Logout</a>
		</div>
		<div class="header-2">
			<p>All Projects</p>
			<a href="/projects/new">New Project</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach var="project" items="${projectsNotAssociated}">
				<tr>
					<td><a href="/projects/${project.id}">${project.title}</a></td>
					<td><span>${project.teamLead.userName}</span></td>
					<td><span>${project.dueDate}</span></td>
					<td><a href="/projects/join/${project.id}" class="button">Join Team</a></td>
				</tr>
			  </c:forEach>
			</tbody>
		</table>
		
		<div class="header-2">
			<p>Your Projects</p>
		</div>
		<table>
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach var="project" items="${projectsAssociated}">
				<tr>
					<td><a href="/projects/${project.id}">${project.title}</a></td>
					<td><span>${project.teamLead.userName}</span></td>
					<td><span>${project.dueDate}</span></td>
					<c:if test="${project.teamLead.id ne sessionScope.userId}">
						<td><a href="/projects/leave/${project.id}" class="button">Leave Team</a></td>
					</c:if>
					<c:if test="${project.teamLead.id == sessionScope.userId}">
						<td><a href="/projects/edit/${project.id}" class="button">Edit</a><a href="/projects/delete/${project.id}" class="button">Delete</a></td>
					</c:if>
				</tr>
			  </c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html> 