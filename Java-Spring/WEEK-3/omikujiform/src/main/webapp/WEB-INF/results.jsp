<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Here's Your Omikuji</h1>
		<div class="container-2">
			<span>
				In ${sessionScope.numberPick} years, you will live in ${sessionScope.city}
				 with ${sessionScope.person} as your roomate, ${sessionScope.endeavor}.
				  The next time you see a ${sessionScope.pet}, you will have good luck.
				  Also, ${sessionScope.message}.
			</span>
		</div>
		<a href="/omikuji">Go Back</a>
	</div>
</body>
</html> 