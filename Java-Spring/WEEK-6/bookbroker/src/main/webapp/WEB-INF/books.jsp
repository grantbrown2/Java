<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Broker</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
			<p>Hello, ${nameInSession}. Welcome to...</p>
		<div class="header">
			<h1>The Book Broker!</h1>
			<a href="/logout">Logout</a>
		</div>
		<div class="header-2">
			<p>Available Books to Borrow</p>
			<a href="/books/new">Add a book to my shelf</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach var="book" items="${books}">
				<tr>
					<td><span>${book.id}</span></td>
					<td><a href="/books/${book.id}">${book.title}</a></td>
					<td><span>${book.author}</span></td>
					<td><span>${book.createdBy}</span></td>
					<td><a href="#" class="button">Borrow</a></td>
				</tr>
			  </c:forEach>
			</tbody>
		</table>
		
		<div class="header-2">
			<p>Books I'm Borrowing...</p>
		</div>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach var="book" items="${books}">
				<tr>
					<td><span>${book.id}</span></td>
					<td><a href="/books/${book.id}">${book.title}</a></td>
					<td><span>${book.author}</span></td>
					<td><span>${book.createdBy}</span></td>
					<td><a href="#" class="button">Return</a></td>
				</tr>
			  </c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html> 