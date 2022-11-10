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
    <title>Book Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<header>
<div>
<h1>Change your Entry</h1>
</div>
<div>
<a href="/books">back to the shelves</a>
</div>
</header>
<main>
<div class="mx-5">
   <form:form action="/books/${book.id }" method="post" modelAttribute="book">
   <input type="hidden" name="_method" value="put">
   <p class="form-group">
   <form:label path="title">Title:</form:label>
   <form:errors path="title"/>
   <form:input class="form-control" path="title"/>
   </p>
   <p class="form-group">
   <form:label path="author">Author:</form:label>
   <form:errors path="author"/>
   <form:input class="form-control" path="author"/>
   </p>
   <p class="form-group">
   <form:label path="thoughts">Thoughts:</form:label>
   <form:errors path="thoughts"/>
   <form:textarea class="form-control" path="thoughts"/>
   </p>
   <form:input type="hidden" path="borrower" value="${book.borrower.id}"/>
   <input class="btn btn-primary" type="submit" value="add"/>
   </form:form>
</div>
</main>
</body>
</html>