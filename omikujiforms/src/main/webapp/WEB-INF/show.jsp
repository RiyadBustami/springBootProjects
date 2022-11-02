<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
<header>
<h1>Here's Your Omikuji!</h1>
</header>
<main>
<div>
<p>
In ${number} years, you will live in ${city} with ${name} as your roommate, ${profession} for a living. The next time you see a ${living_thing}, you will have good luck. Also, ${comment}
</p>
</div>
<a href="/omikuji">Go Back</a>
</main>
</body>
</html>