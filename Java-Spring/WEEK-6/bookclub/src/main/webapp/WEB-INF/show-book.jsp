<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Club</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>${book.title}</h1>
			<a href="/books">Back to the shelves</a>
			<a href="/logout">Logout</a>
		</div>
		<span class="sub-header sub-header-title">
			<c:choose>
				<c:when test="${book.createdBy == sessionScope.userName}">
					You
				</c:when>
				<c:otherwise>
					${book.createdBy}
				</c:otherwise>
			</c:choose>
			read ${book.title} by ${book.author}
		</span>
		<br/>
		<span class="sub-header">Here are ${book.createdBy}'s thoughts:</span>
		<div class="thoughts">
			<span class="thoughts-content">${book.myThoughts}</span>
		</div>
		<c:if test="${book.createdBy == sessionScope.userName}">
			<div class="actions">
				<a href="/books/edit/${book.id}">Edit</a>
				<a href="/books/delete/${book.id}">Delete</a>
			</div>
		</c:if>
	</div>
</body>
</html> 