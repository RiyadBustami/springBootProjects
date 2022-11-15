<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit your event</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<header class="container">
		<div class="mx-5">
			<h1>Welcome, ${loggedUser.firstName}</h1>
			<p>${loggedUser.state}</p>
			<div class="row">
				<a href="/events" class="col"> Go Back</a> <a href="/logout"
					class="col">Logout</a>
			</div>
		</div>
	</header>

	<main>
		<div class="mx-5">
			<div class="row">
				<div class="col-5">
					<h2 class="row">${event.name}</h2>
					<form:form action="/events/${event.id}" method="post" modelAttribute="event">
						<input type="hidden" name="_method" value="put" />
						<div class="row my-3">
							<form:label path="name">Name</form:label>
							<form:errors path="name" class="text-danger" />
							<form:input path="name" />
						</div>
						<div class="row my-3">
							<form:label path="date">Date</form:label>
							<form:errors path="date" class="text-danger" />
							<form:input type="date" path="date" />
						</div>
						<div class="row my-3">
							<form:label path="location">Location</form:label>
							<form:errors path="location" class="text-danger" />
							<form:input path="location" class="col-9" />
							<form:select path="state" class="col-3">
								<form:options items="${states}" />
							</form:select>
						</div>
						<form:hidden path="owner" />
						<div class="row my-3 text-end">
							<input type="submit" value="submit" class="col-3 btn btn-primary">
						</div>
					</form:form>
				</div>
				<div class="col-1"></div>
			</div>
		</div>
	</main>

</body>
</html>