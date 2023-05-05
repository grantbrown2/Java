<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login & Registration</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Welcome!</h1>
		<p>Join our growing community.</p>
		<div class="register">
			<h2>Register</h2>
			<form:form acton="/register" method="post" modelAttribute="newUser">
				<div class="input">
					<form:label path="userName">User Name: </form:label>
					<form:input path="userName"/>
				</div>
				<div class="input">
					<form:label path="email">Email: </form:label>
					<form:input path="email"/>
				</div>
				<div class="input">
					<form:label path="password">Password: </form:label>
					<form:input path="password"/>
				</div>
				<div class="input">
					<form:label path="confirm">Confirm Password: </form:label>
					<form:input path="confirm"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
		<div class="login">
			<h2>Log in</h2>
			<form:form acton="/login/user" method="post" modelAttribute="newLogin">
				<div class="input">
					<form:label path="email">Email: </form:label>
					<form:input path="email"/>
				</div>
				<div class="input">
					<form:label path="password">Password: </form:label>
					<form:input path="password"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html> 