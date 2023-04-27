<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books!</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>New Book!</h1>
		<form:form action="/books" method="post" modelAttribute="book">
			<form:errors path="title" class="error"/>
			<div>
				<form:label path="title">Title</form:label>
				<form:input path="title" />
			</div>
			<form:errors path="description" class="error"/>
			<div>
				<form:label path="description">Description</form:label>
				<form:textarea path="description" />
			</div>
			<form:errors path="language" class="error"/>
			<div>
				<form:label path="language">Language</form:label>
				<form:input path="language" />
			</div>
			<form:errors path="numberOfPages" class="error"/>
			<div>
				<form:label path="numberOfPages">Pages</form:label>
				<form:input type="number" path="numberOfPages"/>
			</div>
			<input type="submit" value="Submit"/>
			<a href="/books">Back</a>
		</form:form>
	</div>
</body>
</html> 