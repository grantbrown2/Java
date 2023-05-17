<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>${product.name}</h1>
		<a href="/">Home</a>
		<div>
		    <p>Categories:</p>
		    <ul>
				<c:forEach var="category" items="${usedCategories}">
					<li><c:out value="${category.name}"></c:out></li>
				</c:forEach>
			</ul>
		</div>
		<form:form action="/products/${product.id}" method="post" modelAttribute="product">
			<form:label path="categories">Add Category:</form:label>
			<select name="categoryId">
	  			<c:forEach var="category" items="${unusedCategories}">
	    			<option value="${category.id}">${category.name}</option>
	 			</c:forEach>
			</select>
			<input type="hidden" name="categoryId" value="${selectedCategoryId}" />

			<input type="submit" value="Add"/>
		</form:form>
	</div>
</body>
</html> 