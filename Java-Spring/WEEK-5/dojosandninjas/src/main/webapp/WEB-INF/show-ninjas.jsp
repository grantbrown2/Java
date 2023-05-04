<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos & Ninjas</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>${dojo.dName} Location Ninjas</h1>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach var="ninja" items="${ninjas}">
				<tr>
					<td><span>${ninja.fName}</span></td>
					<td><span>${ninja.lName}</span></td>
					<td><span>${ninja.age}</span></td>
				</tr>
			  </c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html> 