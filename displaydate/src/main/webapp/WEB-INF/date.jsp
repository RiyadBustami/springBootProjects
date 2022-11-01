<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
</head>
<body>
<main style="text-align: center;color: blue;margin-top: 30%">
<h1>
<c:out value="${date}"></c:out>
</h1>
</main>
<script type="text/javascript">
confirm("This is the date template");
</script>
</body>
</html>