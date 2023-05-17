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
		<h1>${category.name}</h1>
		<a href="/">Home</a>
		<div>
		    <p>Products:</p>
		    <ul>
				<c:forEach var="product" items="${usedProducts}">
					<li><c:out value="${product.name}"></c:out></li>
				</c:forEach>
			</ul>
		</div>
		<form:form action="/categories/${category.id}" method="post" modelAttribute="category">
			<form:label path="products">Add Product:</form:label>
			<select name="productId">
	  			<c:forEach var="product" items="${unusedProducts}">
	    			<option value="${product.id}">${product.name}</option>
	 			</c:forEach>
			</select>
			<input type="hidden" name="productId" value="${selectedProductId}" />

			<input type="submit" value="Add"/>
		</form:form>
	</div>
</body>
</html> 