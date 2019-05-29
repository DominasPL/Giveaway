<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/29/19
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zmiana hasła</title>
</head>
<body>

<form:form modelAttribute="form" method="post">
    <form:errors path="*"/>
    <div class="form-group">
        Podaj hasło
        <form:password placeholder="Podaj hasło" path="password"/>
    </div>
    <div class="form-group">
        Potwierdź hasło
        <form:password placeholder="Potwierdź hasło" path="confirmedPassword"/>
    </div>
    <div class="form-group form-group--buttons">
        <button type="submit" class="btn">Potwierdź</button>
        <a class="btn btn-success" href="/profile" role="button">Powrót</a>
    </div>
</form:form>

</body>
</html>
