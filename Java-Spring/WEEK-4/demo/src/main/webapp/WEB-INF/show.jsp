<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books!</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Title: ${showBook.title}</h1>
		<span>Description: ${showBook.description}</span>
		<br>
		<span>Language: ${showBook.language}</span>
		<br>
		<span>Number of pages: ${showBook.numberOfPages}</span>
		<br>
		<a href="/books" class="back-btn">Back</a>
	</div>
</body>
</html>