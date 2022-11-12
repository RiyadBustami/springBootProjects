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
    <title>Props Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #D5A6BD; ">
<header class="my-3">
<div class="mx-5">
<div class="row">
<h1 class="col text-start">Project: ${project.title}</h1>
<a href="/projects/dashboard" class="text-end">Back to Dashboard</a>
</div>
<div>
<small>Project Lead: ${project.leader.firstName}</small>
</div>
</div>
</header>
<main>
<div class="mx-5">

<div>
<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
<div>
<form:label path="ticket" class="col">Add a task ticket for this team:</form:label>
<form:textarea path="ticket" class="col"/>
</div>
<form:errors path="ticket" class="text-danger"/>
<form:hidden path="project" value="${project.id}"/>
<form:hidden path="creator" value="${userId}"/>
<input type="submit" value="Submit"/>

</form:form>
</div>

</div>

<div class="row">
<div class="col m-5">
<c:forEach var="task" items="${projTasks}">
<h5>Added by ${task.creator.firstName} at <fmt:formatDate pattern="hh:mma MMM d" value="${task.createdAt}"/> </h5>
<p>${task.ticket}</p>
</c:forEach>
</div>
<div class="col">

</div>


</div>

</main>
   
</body>
</html>