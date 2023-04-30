<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Burger!</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Edit A Burger</h1>
		<form:form action="/burger/update/${burger.id}" method="put" modelAttribute="burger">
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