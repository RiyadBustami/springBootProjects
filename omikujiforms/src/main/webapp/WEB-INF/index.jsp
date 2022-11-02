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
<h1>Send an Omikuji!</h1>
</header>
<main>
<div>
<form action="/omikuji/show" method="post">
<p>
<label for="number">Pick any number from 5 to 25</label>
</p>
<p>
<input type="number" id="number" name="number" min="5" max="25"/>
</p>
<p>
<label for="city">Enter the name of any city:</label>
</p>
<p>
<input type="text" name="city" id="city"/>
</p>
<p>
<label for="name">Enter the name of any real person:</label>
</p>
<p>
<input type="text" name="name" id="name"/>
</p>
<p>
<label for="profession">Enter professional endeavor or hobby:</label>
</p>
<p>
<input type="text" name="profession" id="profession"/>
</p>
<p>
<label for="living_thing">Enter any type of living thing:</label>
</p>
<p>
<input type="text" name="living_thing" id="living_thing"/>
</p>
<p>
<label for="comment">Say something nice to someone:</label>
</p>
<p>
<textarea name="comment" cols="30" rows="5" placeholder="You do not realize how happy you make others."></textarea>
</p>
<input type="submit" value="Send"/>
</form>
</div>
</main>
</body>
</html>