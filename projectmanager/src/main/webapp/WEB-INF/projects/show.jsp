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
    <title>Create a Project</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<header class="my-3">
<div class="row mx-5">
<h1 class="col-9">Project Details</h1>
<a href="/projects/dashboard" class="col btn btn-warning">Back to Dashboard</a>
</div>
</header>
<main>
<div class="mx-5 col">
<div class="row text-start">
	<p class="col">Project: </p>
	<p class="col">${project.title}</p>
	<p class="col"></p>
</div>
<div class="row text-start">
	<p class="col">Description: </p>
	<p class="col">${project.description}</p>
	<p class="col"></p>
</div>
<div class="row text-start">
	<p class="col">Due Date: </p>
	<p class="col"><fmt:formatDate pattern="dd/MM/yyyy" value="${project.dueDate}"/></p>
	<p class="col"></p>
</div>
<c:if test="${project.leader.id==userId || isMember }">
<div class="row">
<a href="/projects/${project.id}/tasks">See tasks!</a>
</div>
</c:if>
<c:if test="${project.leader.id==userId }">
<div class="row text-end">
<form:form action="/projects/${project.id}" method="post">
<input type="hidden" name="_method" value="delete"/>
<input type="submit" value="Delete Project" class="btn btn-danger">
</form:form>
</div>
</c:if>
</div>
</main>
   
</body>
</html>