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
		<h1>Project Details</h1>
		<a href="/dashboard">Home</a>
		<table>
			<thead>
				<tr>
					<th>Project</th>
					<th>Description</th>
					<th>Due Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><span>${project.title}</span></td>
					<td><span>${project.description}</span></td>
					<td><span>${project.dueDate}</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html> 