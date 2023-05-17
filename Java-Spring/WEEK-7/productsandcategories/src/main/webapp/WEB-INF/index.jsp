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
		<h1>Home Page</h1>
		<div class="header">
			<a href="/products/new">New Product</a>
			<a href="/categories/new">New Category</a>
		</div>
		<div class="tables">
			<table>
				<thead>
					<tr>
						<th>Products</th>
					</tr>
				</thead>
				<tbody>
				  <c:forEach var="product" items="${products}">
					<tr>
						<td><a href="/products/${product.id}">${product.name}</a></td>
					</tr>
				  </c:forEach>
				</tbody>
			</table>
			<table>
				<thead>
					<tr>
						<th>Categories</th>
					</tr>
				</thead>
				<tbody>
				  <c:forEach var="category" items="${categories}">
					<tr>
						<td><a href="/categories/${category.id}">${category.name}</a></td>
					</tr>
				  </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html> 