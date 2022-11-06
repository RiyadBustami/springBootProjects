<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="language" items="${languages}">
					<tr>
						<td><a href="/languages/${language.id}">${language.name}</a></td>
						<td>${language.creator}</td>
						<td>${language.currentVersion}</td>
						<td><a href="/languages/edit/${language.id}"><span>Edit</span></a>|
							<form action="/languages/${language.id}" method="post"
								style="display: inline;">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete" style="display: inline;">
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<h2>Add an language:</h2>
	<div>
		<h1>New Language</h1>
		<form:form action="/languages" method="post" modelAttribute="language">
			<p>
				<form:label path="name">Name:</form:label>
				<form:input path="name" />
				<form:errors path="name" />
			</p>
			<p>
				<form:label path="creator">Creator:</form:label>
				<form:input path="creator" />
				<form:errors path="creator" />
			</p>
			<p>
				<form:label path="currentVersion">Version:</form:label>
				<form:input path="currentVersion" />
				<form:errors path="currentVersion" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>