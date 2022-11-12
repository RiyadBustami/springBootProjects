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
    <title>Edit a Project</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<header>
<div>
<h1>Edit your Project</h1>
</div>
<div>
</div>
</header>
<main>
<div class="mx-5">
   <form:form action="/projects/${project.id }" method="post" modelAttribute="project">
   <input type="hidden" name="_method" value="put"/>
   <p class="form-group">
   <form:label path="title">Project Title:</form:label>
   <form:errors path="title"/>
   <form:input class="form-control" path="title"/>
   </p>
   <p class="form-group">
   <form:label path="description">Project Description:</form:label>
   <form:errors path="description"/>
   <form:textarea class="form-control" path="description"/>
   </p>
   <p class="form-group">
   <form:label path="dueDate">Due Date:</form:label>
   <form:errors path="dueDate"/>
   <form:input type="date" class="form-control" path="dueDate"/>
   </p>
   <form:hidden path="leader" value="${userId}"/>
   <a href="/projects/dashboard" class="btn btn-danger">Cancel</a>
   <input class="btn btn-primary" type="submit" value="add"/>
   </form:form>
</div>
</main>
   
</body>
</html>