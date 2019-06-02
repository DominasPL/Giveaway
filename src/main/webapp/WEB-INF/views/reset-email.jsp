<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/2/19
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset email</title>
</head>
<body>

<form:form modelAttribute="email" method="post">
    <form:errors path="*"/>
    <div class="form-group">
        <form:input placeholder="Podaj email" path="email"/>
    </div>
    <div class="form-group form-group--buttons">
        <button type="submit" class="btn">Wyślij</button>
    </div>
</form:form>


</body>
</html>
