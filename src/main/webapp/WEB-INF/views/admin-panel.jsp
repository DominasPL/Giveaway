<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/15/19
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<h1>Panel administratora</h1>
<a class="btn btn-success" href="/login/admin/admins" role="button">Admini</a>
<a class="btn btn-success" href="/login/admin/users" role="button">Użytkownicy</a>
<a class="btn btn-success" href="/login/admin/institutions" role="button">Instytucje</a>
<a class="btn btn-success" href="/login/admin/gifts" role="button">Dary</a>
<a class="btn btn-success" href="/logout" role="button">Wyloguj</a>


</body>
</html>
