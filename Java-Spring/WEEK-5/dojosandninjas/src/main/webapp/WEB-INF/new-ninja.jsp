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
		<h1>New Ninja</h1>
		<form:form action="/ninjas/create" method="post" modelAttribute="ninja">
			<form:label path="dojo">Dojo: </form:label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}" path="dojo">
						<c:out value="${dojo.dName}" />
					</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="fName" class="error" />
			<div>
				<form:label path="fName">First Name: </form:label>
				<form:input path="fName" />
			</div>
			<form:errors path="lName" class="error" />
			<div>
				<form:label path="lName">Last Name: </form:label>
				<form:input path="lName" />
			</div>
			<form:errors path="age" class="error" />
			<div>
				<form:label path="age">Age: </form:label>
				<form:input path="age" />
			</div>
			<input type="submit" value="Create"/>
		</form:form>
		<a href="/dojos/new">Create a new Dojo</a>
	</div>
</body>
</html> 