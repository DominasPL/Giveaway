<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 4/26/19
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="/">Start</a></li>
            <li class="nav-item"><a class="nav-link" href="/about-service">O co chodzi</a></li>
            <li class="nav-item"><a class="nav-link" href="/about-us">O nas</a></li>
            <li class="nav-item"><a class="nav-link" href="/organizations">Fundacje i organizacje</a></li>
            <li class="nav-item"><a class="nav-link" href="/admin/contact">Kontakt</a></li>
        </ul>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="/login"><span class="glyphicon glyphicon-log-in"></span>Zaloguj</a></li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="/register"><span class="glyphicon glyphicon-user"></span>Zalóż konto</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item"><a class="nav-link" href="/logout"><span class="glyphicon glyphicon-log-out"></span>Wyloguj</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>