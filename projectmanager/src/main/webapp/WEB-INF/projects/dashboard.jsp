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
    <title>Project Manager Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<header class="mx-5">
<div class="row">
<h1 class="col">Welcome, ${currUser.firstName}</h1>
<a href="/logout" class="col text-start">log out</a>
</div>
</header>

<main class="mx-5">
<div class="row">
<h5 class="col-9 text-start">All Projects</h5>
<a href="/projects/new" class="col btn btn-primary btn-sm">+ new project</a>
</div>
<table class="table">
<thead>
<tr>
<th>Project</th>
<th>Team Lead</th>
<th>Due Date</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="project" items="${allProjects}">
<c:if test="${project.leader.id!=currUser.id }">
<tr>
<td>${project.title}</td>
<td>${project.leader.firstName}</td>
<td>${project.dueDateFormatted}</td>
<td>
<form:form action="/projects/join" method="post" modelAttribute="membersProjects">
<form:hidden path="member" value="${currUser.id}"/>
<form:hidden path="project" value="${project.id}"/>
<input type="submit" value="Join Team" class="btn btn-link">
</form:form>
</td>
</tr>
</c:if>
</c:forEach>
</tbody>
</table>

<div class="text-start"><h5>Your Projects</h5></div>
<table class="table">
<thead>
<tr>
<th>Project</th>
<th>Team Lead</th>
<th>Due Date</th>
<th class="text-center">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="project" items="${yourProjects}">
<tr>
<td>${project.title}</td>
<td>${project.leader.firstName}</td>
<td>${project.dueDateFormatted}</td>
<td class="text-center">
<c:choose>
<c:when test="${project.leader.id==currUser.id }">
<a href="/projects/edit/${project.id}">Edit</a>
</c:when>
<c:otherwise>
<form:form action="/projects/leave/${project.id}" method="post">
<input type="hidden" name="_method" value="delete"/>
<input type="submit" value="Leave Team" class="btn btn-link">
</form:form>
</c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</main>
   
</body>
</html>