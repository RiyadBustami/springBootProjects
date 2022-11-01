<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Fruit Store</title>
</head>
<body>
<header class="container">
<h1>Fruit Store</h1>
</header>
<main class="container">
<table class="table">
<tr>
<th>Name</th>
<th>Price</th>
</tr>
<c:forEach var="fruit" items="${fruits}">
<tr>
<td class=""><c:out value="${fruit.name}"/></td>
<td><c:out value="${fruit.price}"/></td>
 </tr>
</c:forEach>
</table>
</main>
</body>
</html>