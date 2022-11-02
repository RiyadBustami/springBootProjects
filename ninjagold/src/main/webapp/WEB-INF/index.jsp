<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>

<body>
    <header>
        <div class="input-group mb-3">
            <span class="input-group-text bg-light" id="basic-addon1">Your Gold:</span>
            <span class="form-control" aria-label="Score" aria-describedby="basic-addon1" style="max-width: 20em;">${counter }</span>
        </div>
    </header>
    <main class="container">
        <table class="table text-center">
        <tr>
            <td>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <form action="/Gold/process_money" method="POST">
                            <h5 class="card-title">Farm</h5>
                            <p class="card-text">(earns 10-20 gold)</p>
                            <input type="hidden" name="field" value="farm">
                            <input type="submit" value="Find Gold" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </td>
            <td>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <form action="/Gold/process_money" method="POST">
                            <h5 class="card-title">Cave</h5>
                            <p class="card-text">(earns 5-10 gold)</p>
                            <input type="hidden" name="field" value="cave">
                            <input type="submit" value="Find Gold" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </td>
            <td>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <form action="/Gold/process_money" method="POST">
                            <h5 class="card-title">House</h5>
                            <p class="card-text">(earns 2-5 gold)</p>
                            <input type="hidden" name="field" value="house">
                            <input type="submit" value="Find Gold" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </td>
            <td>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <form action="/Gold/process_money" method="POST">
                            <h5 class="card-title">Quest</h5>
                            <p class="card-text">(earns/takes 0-50 gold)</p>
                            <input type="hidden" name="field" value="quest">
                            <input type="submit" value="Find Gold" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </td>
            </tr>
        </table>
    </main>
    <footer>
        <div class="text-bg-dark" style="min-height:18em;max-height: 18em; overflow: scroll;">
        <c:forEach var="message" items="${activities }">
        	<p style="color: ${message.get(1)};"><c:out value="${message.get(0)}"></c:out></p>
        </c:forEach>
        </div>
    </footer>
</body>
</html>