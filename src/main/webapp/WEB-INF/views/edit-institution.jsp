<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/21/19
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja instytucji</title>
</head>
<body>

<h2>Edycja instytucji</h2>

    <form:form modelAttribute="form" method="post">
        <form:errors path="*"/>
        <div class="form-group">
            <form:input placeholder="Podaj nazwe" path="name"/>
        </div>
        <div class="form-group form-group--buttons">
            <button type="submit" class="btn">Potwierdź</button>
            <a href="/admin/panel/institutions" class="btn btn--without-border">Powrót</a>
        </div>
    </form:form>

</body>
</html>
