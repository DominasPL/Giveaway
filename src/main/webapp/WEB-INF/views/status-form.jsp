<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/31/19
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
</head>
<body>

<form:form modelAttribute="status" method="post">
    Odebrany:
    <form:errors path="*"/>
    <form:checkbox path="received"/> <br>
    <a class="btn btn-success" href="/my-gifts" role="button">Powrót</a> <br>
    <input type="submit" value="Potwierdź">
</form:form>


</body>
</html>
