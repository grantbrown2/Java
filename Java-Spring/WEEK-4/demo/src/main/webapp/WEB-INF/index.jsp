<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books!</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>All Books</h1>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th>Number Of Pages</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach var="book" items="${books}">
				<tr>
					<td><span>${book.id}</span></td>
					<td><a href="/books/${book.id}">${book.title}</a></td>
					<td><span>${book.language}</span></td>
					<td><span>${book.numberOfPages}</span></td>
				</tr>
			  </c:forEach>
			</tbody>
		</table>
		<a href="/books/new">Create New Book</a>
	</div>
</body>
</html> 