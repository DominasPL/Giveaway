<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <button type="submit" class="btn btn-primary btn-block">Submit</button>
</form:form>

</body>
</html>
