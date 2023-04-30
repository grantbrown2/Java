<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Expense Details</h1>
		<a href="/">Go Back</a>
		<p>Expense Name: ${expense.expenseName}</p>
		<p>Vendor: ${expense.vendor}</p>
		<p>Amount: ${expense.amount}</p>
		<p>Description: ${expense.description}</p>
	</div>
</body>
</html> 