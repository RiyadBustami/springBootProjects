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
    <title>Product Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<main>
<h1 class="text-center">${product.name}</h1>
<p><a href="/">Home</a></p>
<div class="border border-bottom"></div>
<h2>Categories:</h2>
<ul>
<c:forEach var="category" items="${product.categories}">
<li><a href="/categories/${category.id}">${category.name}</a></li>
</c:forEach>
</ul>
<div class="border border-bottom"></div>
<h2>Add Category:</h2>
<form action="/products/${product.id}" method="post" >
<select name="selectedCategory">
<c:forEach var="category" items="${categories}">
<option value="${category.id}">${category.name}</option>
</c:forEach>
</select>
<input type="submit" value="Add"/>
</form>
</main>
</body>
</html>