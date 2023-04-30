<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<form:form action="/expenses/update/${expense.id}" method="put" modelAttribute="expense">
			<form:errors path="expenseName" class="error"/>
			<div>
				<form:label path="expenseName">Expense Name: </form:label>
				<form:input path="expenseName" />
			</div>
			<form:errors path="vendor" class="error"/>
			<div>
				<form:label path="vendor">Vendor Name: </form:label>
				<form:textarea path="vendor" />
			</div>
			<form:errors path="amount" class="error"/>
			<div>
				<form:label path="amount">Amount: </form:label>
				<form:input type="number" step="any" path="amount" />
			</div>
			<form:errors path="description" class="error"/>
			<div>
				<form:label path="description">Description: </form:label>
				<form:input path="description"/>
			</div>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html> 