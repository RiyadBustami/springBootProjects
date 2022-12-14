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
<h1>${book.title}</h1>
</div>
<div class="col text-end">
<a href="/books">back to the shelves</a>
</div>
</header>
<main>
<div>
<h3>${book.user.userName} read ${book.title} by ${book.author}.</h3>
</div>

<h4>Here are <c:choose ><c:when test="${book.user.id==loggedUser.id}">your </c:when><c:otherwise>${book.user.userName}'s </c:otherwise></c:choose> thoughts:</h4>

<div class="border-top"></div>
<div class="py-3">
<p class="mx-5">${book.thoughts}</p>
</div>
<div class="border-bottom"></div>
<c:if test="${book.user.id==loggedUser.id}">
<div>
<a href="/books/${book.id}/edit" class="d-inline"><button class="btn btn-primary">Edit</button></a>
<form action="/books/${book.id}" method="post">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Delete" class="btn btn-danger"/>
</form>
</div>
</c:if>
</main>
   
</body>
</html>