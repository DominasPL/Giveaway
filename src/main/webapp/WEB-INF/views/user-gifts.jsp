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
    <title>Moje dary</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<table>
    <thead>
    <tr>
        <th colspan="4" style="text-align: center">Dary</th>
    </tr>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Data utworzenia</th>
        <th scope="col">Ilość worków</th>
        <th scope="col">Instytucja</th>
        <th scope="col">Data odebrania</th>
        <th scope="col">Czy odebrany</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${gifts}" var="gift" varStatus="giftStatus">
        <tr>
            <td>${giftStatus.count}</td>
            <td>${gift.created}</td>
            <td>${gift.amount}</td>
            <td>${gift.institution}</td>
            <td>${gift.taken}</td>
            <td>${gift.received}</td>
            <td><a class="btn btn-primary" href="/my-gifts/${gift.id}">Więcej informacji</a></td>
            <td><a class="btn btn-success" href="/my-gifts/${gift.id}/change-status">Zmiana statusu</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a class="btn btn-success" href="/" role="button">Powrót</a>

</body>
</html>
