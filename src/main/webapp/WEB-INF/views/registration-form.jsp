<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/13/19
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
    <form:form modelAttribute="form" method="post">
        <form:errors path="*"/>
            <form:input placeholder="Podaj email" path="email"/>
            <form:password placeholder="Podaj hasło" path="password"/>
            <form:password placeholder="Potwierdź hasło" path="confirmedPassword"/>
            <button type="submit" class="btn btn-primary btn-block">Potwierdź</button>
    </form:form>
</body>
</html>
