<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter!</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>You have visited the counter site <c:out value="${count}"/> times.</h1>
		<form action="/clear" method="POST">
			<button>Reset</button>
		</form>
		<form action="/count" method="post">
			<input type="number" name="number">
			<label></label>
		</form>
	</div>
</body>
</html> 