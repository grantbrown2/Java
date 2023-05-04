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
	<div class="container-dojo">
		<h1>New Dojo</h1>
		<form:form action="/dojos/create" method="post" modelAttribute="dojo">
			<form:errors path="dName" class="error" />
			<div>
				<form:label path="dName">Name: </form:label>
				<form:input path="dName" />
			</div>
			<input type="submit" value="Create"/>
		</form:form>
		<a href="/ninjas/new">Create a new Ninja</a>
	</div>
</body>
</html> 