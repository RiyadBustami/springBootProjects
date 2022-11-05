<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Books</title>
</head>
<body>
<main>
<h1>New Book</h1>
<form action="/books" method="post">
<p><label for="title">Title:</label></p>
<p><input type="text" name="title" id="title"></p>
<p><label for="description"> Description:</label></p>
<p><textarea rows="15" cols="45" name="description" id="description"></textarea></p>
<p><label for="language">Language:</label></p>
<p><input type="text" name="language" id="language"></p>
<p><label for="pages">Pages:</label></p>
<p><input type="number" name="pages" id="pages" min="100" max="1000"></p>
<p><input type="submit" value="Submit"></p> 
</form>
</main>
</body>
</html>