<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loops</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Fruit Store</h1>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="fruit" items="${fruits}">
				<tr>
					<td><c:out value="${fruit.name}"/></td>
					<td><c:out value="${fruit.price}"/></td>
				</tr>
			</c:forEach>
		
		</table>
	</div>
</body>
</html> 