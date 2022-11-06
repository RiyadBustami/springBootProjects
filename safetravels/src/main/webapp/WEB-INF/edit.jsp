<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit My Task</title>
</head>
<body>
<div>
<h1>Edit Expense</h1>
<a href="/expenses">Go Back</a>
</div> 
<h1>Edit Book</h1>
<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Expense:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/>
    </p>
    <p>
        <form:label path="description">Pages</form:label>
        <form:errors path="description"/>     
        <form:textarea path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>


</body>
</html>