<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
	<div class="container">
		<h1>Project Manager</h1>
		<p>A place for teams to manage projects.</p>
		<div class="container-2">
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
						<form:input path="password" type="password"/>
					</div>
					<form:errors path="confirmPassword" class="error"/>
					<div class="input">
						<form:label path="confirmPassword">Confirm Password: </form:label>
						<form:input path="confirmPassword" type="password"/>
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
						<form:input path="loginPassword" type="password"/>
					</div>
					<input type="submit" value="Submit"/>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html> 