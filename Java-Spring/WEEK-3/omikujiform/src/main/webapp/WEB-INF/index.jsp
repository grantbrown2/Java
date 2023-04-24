<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji</h1>
		<form action="/omikuji/show/process" method="post">
			<label for="numberPick">Pick any number from 5 to 25:</label>
			<input type="number" name="numberPick">
			<br>
			<br>
			<label for="city">Enter the name of any city:</label>
			<input type="text" name="city">
			<br>
			<br>
			<label for="person">Enter the name of any real person:</label>
			<input type="text" name="person">
			<br>
			<br>
			<label for="endeavor">Enter professional endeavor or hobby:</label>
			<input type="text" name="endeavor">
			<br>
			<br>
			<label for="pet">Enter any type of living thing:</label>
			<input type="text" name="pet">
			<br>
			<br>
			<label for="message">Say something nice to someone:</label>
			<input type="text" name="message">
			<br>
			<br>
			<p>Send and show a friend</p>
			<input type="submit" value="Send">
		</form>
	</div>
</body>
</html>  