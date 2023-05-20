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
			<h1>Edit Project!</h1>
		</div>
		<form:form action="/projects/edit/${project.id}" method="put" modelAttribute="project">
			<form:errors path="title" class="error"/>
			<div class="input">
				<form:label path="title">Project Title: </form:label>
				<form:input path="title"/>
			</div>
			<form:errors path="description" class="error"/>
			<div class="input">
				<form:label path="description">Project Description: </form:label>
				<form:input path="description"/>
			</div>
			<form:errors path="dueDate" class="error"/>
			<div class="input">
				<form:label path="dueDate">Due Date: </form:label>
				<form:input path="dueDate" type="date"/>
			</div>
			<a href="/dashboard">Cancel</a>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html> 