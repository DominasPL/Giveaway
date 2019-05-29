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
    <title>Szczegóły daru</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<table>
    <thead>
    <tr>
        <th colspan="12" style="text-align: center">Dary</th>
    </tr>
    <tr>
        <th scope="col">Utworzono</th>
        <th scope="col">Odebrano</th>
        <th scope="col">Ilość worków</th>
        <th scope="col">Miasto</th>
        <th scope="col">Instytucja</th>
        <th scope="col">Komu podarowane</th>
        <th scope="col">Rzeczy</th>
        <th scope="col">Ulica</th>
        <th scope="col">Miasto odbioru</th>
        <th scope="col">Kod pocztowy</th>
        <th scope="col">Numer telefonu</th>
        <th scope="col">Informacja dla kuriera</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${gift.created}</td>
            <td>${gift.taken}</td>
            <td>${gift.amount}</td>
            <td>${gift.location.name}</td>
            <td>${gift.institution.name}</td>
            <td>${gift.groups}</td>
            <td>${gift.things}</td>
            <td>${gift.street}</td>
            <td>${gift.town}</td>
            <td>${gift.postalCode}</td>
            <td>${gift.phoneNumber}</td>
            <td>${gift.comment}</td>
        </tr>
    </tbody>
</table>
<a class="btn btn-success" href="/my-gifts" role="button">Powrót</a>

</body>
</html>
</html>
