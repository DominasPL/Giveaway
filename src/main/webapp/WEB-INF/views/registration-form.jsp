<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Registration</title>
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
    <h2>Załóż konto</h2>
    <form:form modelAttribute="form" method="post">
        <form:errors path="*"/>
        <div class="form-group">
            <form:input placeholder="Podaj email" path="email"/>
        </div>
        <div class="form-group">
            <form:password placeholder="Podaj hasło" path="password"/>
        </div>
        <div class="form-group">
            <form:password placeholder="Potwierdź hasło" path="confirmedPassword"/>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button type="submit" class="btn">Załóż konto</button>
        </div>
     </form:form>
</section>

<jsp:include page="../elements/footer.jsp"/>

</body>
</html>


