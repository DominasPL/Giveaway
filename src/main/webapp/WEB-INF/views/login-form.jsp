<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Logowanie</title>
    <link rel="stylesheet" href="/media/css/style.css" />
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login">Zaloguj</a></li>
            <li class="highlighted"><a href="/register">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="/">Start</a></li>
            <li><a href="/about-service">O co chodzi?</a></li>
            <li><a href="/about-us">O nas</a></li>
            <li><a href="/organizations">Fundacje i organizacje</a></li>
            <li><a href="/contact">Kontakt</a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form method="post" action="/login">
        <c:if test="${param.error!=null}">
            <span>Nieprawidłowe dane logowania!</span> <br>
        </c:if>
        <c:if test="${param.logout != null}">
            <span>Zostałeś wylogowany!</span> <br>
        </c:if>
        <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" name="email" required min="3" max="50" aria-describedby="emailHelp" placeholder="Podaj email">
        </div>
        <div class="form-group">
            <label>Hasło</label>
            <input type="password" class="form-control" name="password" required min="3" max="20" placeholder="Podaj hasło">
            <a href="/password-reset" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form>
</section>

<jsp:include page="../elements/footer.jsp"/>

</body>
</html>

