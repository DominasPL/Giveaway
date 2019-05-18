<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/18/19
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>


    <form:form modelAttribute="form" method="post">
        <form:errors path="*"/>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input id="email" placeholder="Podaj email" path="email"/>
        </div>
        <div class="form-group">
            <label for="password">Hasło</label>
            <form:password id="password" placeholder="Podaj hasło" path="password"/>
        </div>
        <div class="form-group">
            <label for="confirm-password">Potwierdź hasło</label>
            <form:password id="confirm-password" placeholder="Potwierdź hasło" path="confirmedPassword"/>
        </div>
        <div class="form-group form-group--buttons">
            <button type="submit" class="btn btn-primary">Potwierdź</button>
            <a href="/admin/panel/admins" class="btn btn-success">Powrót</a>
        </div>
    </form:form>

</body>
</html>
