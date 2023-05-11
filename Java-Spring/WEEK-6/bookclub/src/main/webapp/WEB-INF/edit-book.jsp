<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InsertTitleHere</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Change your Entry!</h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<form:form action="/books/update/${book.id}" method="put" modelAttribute="book">
			<form:errors path="title" class="error"/>
			<div class="input">
				<form:label path="title">Title: </form:label>
				<form:input path="title"/>
			</div>
			<form:errors path="author" class="error"/>
			<div class="input">
				<form:label path="author">Author: </form:label>
				<form:input path="author"/>
			</div>
			<form:errors path="myThoughts" class="error"/>
			<div class="input">
				<form:label path="myThoughts">My Thoughts: </form:label>
				<form:input path="myThoughts"/>
			</div>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html> 