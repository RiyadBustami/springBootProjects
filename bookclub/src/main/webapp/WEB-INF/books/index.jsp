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
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<header class="row">
<div class="col">
<h1>Welcome, ${loggedUser.userName}</h1>
<p>Books from everyone's shelves:</p>
</div>
<div class="col text-end">
<p class="mx-2"><a href="/logout">logout</a></p>
<p class="mx-2"><a href="/books/new">+ Add a book to my shelf</a></p>
</div>
</header>
<main>
<div class="col mx-5">
<table class="table">
<thead>
<tr>
<th>ID</th>
<th>Title</th>
<th>Author Name</th>
<th>Posted By</th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${allBooks}">
<tr>
<td>${book.id}</td>
<td><a href="/books/${book.id}">${book.title}</a></td>
<td>${book.author}</td>
<td>${book.user.userName}</td>
</tr>

</c:forEach>
</tbody>
</table>
</div>
</main>
</body>
</html>