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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Login And Registration</title>
</head>
<body>
<header class="container">
	<h1 class="text-primary">Book Club</h1>
	<p>A place for friends to share thoughts on books.</p>
</header>
<main class="row">
	<div class="col border-end">
	<form:form action="/register" method="post" modelAttribute="newUser">

		<table class="mx-1">
			<thead>
				<tr>
					<td colspan="2" class="fs-1">Register</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<td class="float-left">User Name:</td>
					<td class="float-left"><form:errors path="userName"
							class="text-danger" /> <form:input class="form-control" path="userName" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Email:</td>
					<td class="float-left"><form:errors path="email"
							class="text-danger" /> <form:input class="form-control" path="email" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Password:</td>
					<td class="float-left"><form:errors path="password"
							class="text-danger" /> <form:input class="form-control" type="password" path="password" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Confirm PW:</td>
					<td class="float-left"><form:errors path="confirm"
							class="text-danger" /> <form:input class="form-control" type="password" path="confirm" />
					</td>
				</tr>
				<tr>
					<td colspan=2><input class="btn btn-primary"
						type="submit" value="Submit" /></td>
				</tr>
			</thead>
		</table>
	</form:form>
	</div>
	<div class="col">
	<form:form action="/login" method="post" modelAttribute="newLogin">

		<table class="mx-1">
			<thead>
				<tr>
					<td colspan="2" class="fs-1">Log In</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<td class="float-left">Email:</td>
					<td class="float-left"><form:errors path="email"
							class="text-danger" /> <form:input class="form-control" path="email" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Password:</td>
					<td class="float-left"><form:errors path="password"
							class="text-danger" /> <form:input class="form-control" type="password" path="password" />
					</td>
				</tr>
				<tr>
					<td colspan=2><input class="btn btn-primary"
						type="submit" value="Submit" /></td>
				</tr>
			</thead>
		</table>
	</form:form>
	</div>
</main>
</body>
</html>