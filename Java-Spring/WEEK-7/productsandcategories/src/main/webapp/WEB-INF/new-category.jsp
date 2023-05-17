<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>New Category</h1>
		<a href="/">Home</a>
		<div class="form">
			<form:form action="/categories/create" method="post" modelAttribute="category">
				<form:errors path="name" class="error" />
				<div class="form-column">
					<form:label path="name">Name:</form:label>
					<form:input path="name"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html> 