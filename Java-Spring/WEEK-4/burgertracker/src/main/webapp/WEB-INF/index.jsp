<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker!</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Burger Tracker</h1>
		<table>
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach var="burger" items="${burgers}">
				<tr>
					<td><a href="#">${burger.burgerName}</a></td>
					<td><span>${burger.restaurantName}</span></td>
					<td><span>${burger.rating}</span></td>
				</tr>
			  </c:forEach>
			</tbody>
		</table>
		<form:form action="/burger/new" method="post" modelAttribute="burger">
			<form:errors path="burgerName" class="error"/>
			<div>
				<form:label path="burgerName">Burger Name: </form:label>
				<form:input path="burgerName" />
			</div>
			<form:errors path="restaurantName" class="error"/>
			<div>
				<form:label path="restaurantName">Restaurant Name: </form:label>
				<form:textarea path="restaurantName" />
			</div>
			<form:errors path="rating" class="error"/>
			<div>
				<form:label path="rating">Rating: </form:label>
				<form:input type="number" path="rating" />
			</div>
			<form:errors path="notes" class="error"/>
			<div>
				<form:label path="notes">Notes: </form:label>
				<form:input path="notes"/>
			</div>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html> 