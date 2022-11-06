<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>language Show</title>
</head>
<body>
<main>
<h1>Name: ${language.name}</h1>
<p>Creator: ${language.creator}</p>
<p>Version: ${language.currentVersion}</p>

</main>
</body>
</html>