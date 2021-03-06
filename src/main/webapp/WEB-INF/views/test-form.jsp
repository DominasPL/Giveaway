<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/21/19
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>

<form:form method="post" modelAttribute="answers">
    <h1>ZAZNACZ CO CHCESZ ODDAC</h1>
    Chrupki: <form:checkbox path="things"
                        value="Chrupki"/> <br>
    Frytki: <form:checkbox path="things"
                         value="Frytki"/> <br>
    Pizza: <form:checkbox path="things"
                         value="Pizza"/> <br>
    Punkty: <form:checkbox path="things"
                           value="Punkty"/> <br>
    <h1>Ilość worków</h1>
    <form:input path="amount"/> <br>
    <h1>Miasto</h1>
    <form:select itemValue="id" itemLabel="name"
                         path="location.id" items="${locations}"/> <br>
    <h1>Komu chcesz pomóc?</h1>
    Danielowi: <form:checkbox path="groups"
                         value="Daniel"/> <br>
    Robertowi: <form:checkbox path="groups"
                           value="Robert"/> <br>
    Łukaszowi: <form:checkbox path="groups"
                          value="Łukasz"/> <br>
    <h1>Wybierz organizacje, której chcesz pomóc:</h1>
    <form:radiobuttons itemValue="id" itemLabel="name"
                 path="institution.id" items="${institutions}"/> <br>

    <h1>Adres odbioru</h1>
    Ulica: <form:input path="street"/> <br>
    Miasto: <form:input path="town"/> <br>
    Kod pocztowy: <form:input path="postalCode"/> <br>
    Numer telefonu: <form:input path="phoneNumber"/> <br>

    <h1>Termin odbioru</h1>
    <label for="start">Data:</label>
    <input type="date" id="start" name="date" min="2019-01-01" max="2020-12-31"> <br>
    <label for="appt">Wybierz godzine:</label>
    <input type="time" id="appt" min="6:00" name="time" max="20:00" required> <br>
    Uwagi dla kuriera: <form:textarea path="comment"/> <br>


    <input type="submit" value="Save">


</form:form>

</body>
</html>
