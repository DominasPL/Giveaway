<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/15/19
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admini</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<div id="table-ranking">
    <table>
        <thead>
        <tr>
            <th colspan="4" style="text-align: center">Admini</th>
        </tr>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Email</th>
            <th scope="col">-</th>
            <th scope="col">-</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${admins}" var="admin" varStatus="adminStatus">
            <tr>
                <td>${adminStatus.count}</td>
                <td>${admin.email}</td>
                <td><a href="/admin/panel/admins/edit/${admin.id}">Edycja</a></td>
                <td><a href="/admin/panel/admins/delete/${admin.id}">Usuń</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-success" href="/admin/panel/admins/add" role="button">Nowy admin</a>
    <a class="btn btn-success" href="/admin/panel" role="button">Powrót</a>

</div>
</body>
</html>
