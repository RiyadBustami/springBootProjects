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
<title>Events</title>
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
			<a href="/logout/">Logout</a>
		</div>
	</header>


	<main>
		<div class="mx-5">
			<div>
				<p>Here are some of the events in your state:</p>
				<table class="table  border">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>Host</th>
							<th>Action/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="event" items="${allEvents}">
							<c:if test="${event.state==loggedUser.state}">
								<tr>
									<td>${event.name}</td>
									<td><fmt:formatDate pattern="MMMM dd, yyyy"
											value="${event.date}" /></td>
									<td>${event.location}</td>
									<td>${event.owner.firstName}</td>
									<td><c:choose>
											<c:when test="${event.isOwner }">
												<form:form action="/events/${event.id}" method="post">
													<a href="/events/${event.id}/edit" class="btn btn-link">edit</a>
													<input type="hidden" name="_method" value="delete" />
													<input type="submit" value="delete" class="btn btn-link" />
												</form:form>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${event.isMember}">
														<form:form action="/events/${event.id}/leave"
															method="post">
															<small>Joining</small>
															<input type="hidden" name="_method" value="delete" />
															<input type="submit" value="leave" class="btn btn-link" />
														</form:form>
													</c:when>
													<c:otherwise>
														<form action="/events/${event.id}/join" method="post">
															<input type="submit" value="Join" class="btn btn-link" />
														</form>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>

				</table>
			</div>
			<div>
				<p>Here are some of the events in other states:</p>
				<table class="table border">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>State</th>
							<th>Host</th>
							<th>Action/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="event" items="${allEvents}">
							<c:if test="${event.state!=loggedUser.state}">
								<tr>
									<td>${event.name}</td>
									<td><fmt:formatDate pattern="MMMM dd, yyyy"
											value="${event.date}" /></td>
									<td>${event.location}</td>
									<td>${event.state}</td>
									<td>${event.owner.firstName}</td>
									<td><c:choose>
											<c:when test="${event.isOwner }">
												<form:form action="/events/${event.id}" method="post">
													<a href="/events/${event.id}/edit" class="btn btn-link">edit</a>
													<input type="hidden" name="_method" value="delete" />
													<input type="submit" value="delete" class="btn btn-link" />
												</form:form>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${event.isMember}">
														<form:form action="/events/${event.id}/leave"
															method="post">
															<small>Joining</small>
															<input type="hidden" name="_method" value="delete" />
															<input type="submit" value="leave" class="btn btn-link" />
														</form:form>
													</c:when>
													<c:otherwise>
														<form action="/events/${event.id}/join" method="post">
															<input type="submit" value="Join" class="btn btn-link" />
														</form>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>

				</table>
			</div>
			<div class="row">
				<div class="col-5">
					<h4 class="row">Create a new Event</h4>
					<form:form action="/events" method="post" modelAttribute="event">
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
						<form:hidden path="owner" value="${userId}" />
						<div class="row my-3 text-end">
							<input type="submit" value="add" class="col-3 btn btn-primary">
						</div>
					</form:form>
				</div>
				<div class="col-1"></div>
			</div>

		</div>
	</main>

</body>
</html>