<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <sec:authorize access="!isAuthenticated()">
            <ul class="nav--actions">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </ul>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <ul class="nav--actions">
                <li class="logged-user">
                    Witaj ${firstName}
                    <ul class="dropdown">
                        <li><a href="/profile">Profil</a></li>
                        <li><a href="#">Ustawienia</a></li>
                        <li><a href="/my-gifts">Moje dary</a></li>
                        <li><a href="/logout">Wyloguj</a></li>
                    </ul>
                </li>
            </ul>
        </sec:authorize>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/about-service" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="/organizations" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br />
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>

            <ul class="slogan--buttons">
                <li><a href="/gift" class="btn btn--large">Oddaj rzeczy</a></li>
                <li><a href="#" class="btn btn--large">Zorganizuj zbiórkę</a></li>
            </ul>
        </div>
    </div>
</header>

<script src="/media/js/app.js"></script>

</body>
</html>
