<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
</head>
<body>
<h1>Save Travels</h1>
<div>
	<table>
	<thead>
	<tr>
	<th>Expense</th>
	<th>Vendor</th>
	<th>Amount</th>	
	</tr>
	</thead>
	<tbody>
	<c:forEach var="expense" items="${expenses}">
	<tr>
	<td>${expense.name}</td>
	<td>${expense.vendor}</td>
	<td>${expense.amount}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
<h2>Add an expense:</h2>
<div> 
<h1>New Book</h1>
<form:form action="/expenses" method="post" modelAttribute="expense">
  <p>  <form:errors path="name"/></p>
  <p>  <form:errors path="vendor"/></p>
 <p>   <form:errors path="amount"/></p>
  <p>  <form:errors path="description"/></p>
    <p>
        <form:label path="name">Expense Name:</form:label>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:input path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:textarea rows="15" cols="45" path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</div>
</body>
</html>