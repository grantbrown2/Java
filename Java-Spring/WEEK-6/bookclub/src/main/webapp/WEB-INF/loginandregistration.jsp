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
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books.</p>
		<div class="register">
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<form:errors path="userName" class="error"/>
				<div class="input">
					<form:label path="userName">User Name: </form:label>
					<form:input path="userName"/>
				</div>
				<form:errors path="email" class="error"/>
				<div class="input">
					<form:label path="email">Email: </form:label>
					<form:input path="email"/>
				</div>
				<form:errors path="password" class="error"/>
				<div class="input">
					<form:label path="password">Password: </form:label>
					<form:input path="password"/>
				</div>
				<form:errors path="confirm" class="error"/>
				<div class="input">
					<form:label path="confirm">Confirm Password: </form:label>
					<form:input path="confirm"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
		<div class="login">
			<h2>Log in</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<form:errors path="loginEmail" class="error"/>
				<div class="input">
					<form:label path="loginEmail">Email: </form:label>
					<form:input path="loginEmail"/>
				</div>
				<form:errors path="loginPassword" class="error"/>
				<div class="input">
					<form:label path="loginPassword">Password: </form:label>
					<form:input path="loginPassword"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html> 