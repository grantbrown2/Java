<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Test</h1>
	<ul>
		<li>Test1</li>
		<li>Test2</li>
		<li>Test3 </li>
	</ul>
	<h2>Fruit of the day</h2>
	<p><c:out value="${fruit}"/></p>
	<c:forEach var="items" items="${test}">
		<p><c:out value="${items}"/></p> 
	</c:forEach>
</body>
</html> 