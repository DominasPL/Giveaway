<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/18/19
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja danych</title>
</head>
<body>

<form:form modelAttribute="form" method="post">
    <form:errors path="*"/>
    <form:hidden path="email"/>
    <div class="form-group">
        <label>Imie</label>
        <form:input class="form-control" placeholder="Podaj imie" path="firstName"/>
    </div>
    <div class="form-group">
        <label>Nazwisko</label>
        <form:input class="form-control" placeholder="Podaj nazwisko" path="lastName"/>
    </div>
    <div class="form-group">
        <label>Numer telefonu</label>
        <form:input class="form-control" placeholder="Poda numer telefonu" path="phoneNumber"/>
    </div>
    <div class="form-group">
        <label>Ulica</label>
        <form:input class="form-control" placeholder="Podaj ulice" path="street"/>
    </div>
    <div class="form-group">
        <label>Numer mieszkania</label>
        <form:input class="form-control" placeholder="Podaj numer mieszkania" path="streetNumber"/>
    </div>
    <div class="form-group">
        <label>Kod pocztowy</label>
        <form:input class="form-control" placeholder="Podaj kod pocztowy" path="postalCode"/>
    </div>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="form-group">
            <label>Aktywny</label>
            <form:input class="form-control" path="active"/>
        </div>
    </sec:authorize>

    <a class="btn btn-success" href="/profile/change-password" role="button">Zmiana hasła</a> <br>


    <button type="submit" class="btn btn-primary btn-block">Submit</button>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <c:choose>
            <c:when test="${form.role=='ROLE_ADMIN'}">
                <a class="btn btn-success" href="/admin/panel/admins" role="button">Powrót</a>
            </c:when>
            <c:otherwise>
                <a class="btn btn-success" href="/admin/panel/users" role="button">Powrót</a>
            </c:otherwise>
        </c:choose>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <a class="btn btn-success" href="/" role="button">Powrót</a>
    </sec:authorize>

</form:form>

</body>
</html>
