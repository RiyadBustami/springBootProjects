<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<main>
<h1 class="text-center">Home Page</h1>
<p><a href="/products/new">New Product</a></p>
<p><a href="/categories/new">New Category</a></p>
<table class="table table-bordered">
<thead>
<tr>
<th scope="col">Products</th>
<th scope="col">Categories</th>
</tr>
</thead>
<tbody>
<tr>
<td>
<ul>
<c:forEach var="product" items="${products}">
<li><a href="/products/${product.id}">${product.name}</a></li>
</c:forEach>
</ul>
</td>
<td>
<ul>
<c:forEach var="category" items="${categories}">
<li><a href="/categories/${category.id}">${category.name}</a></li>
</c:forEach>
</ul>
</td>
</tr>
</tbody>
</table>
</main>
</body>
</html>