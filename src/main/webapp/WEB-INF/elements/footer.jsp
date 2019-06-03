<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/3/19
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
</head>
<body>


<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię" /></div>
            <div class="form-group form-group--50"><input type="text" name="surname" placeholder="Nazwisko" /></div>

            <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="https://www.facebook.com/" class="btn btn--small"><img src="/media/images/icon-facebook.svg"/></a>
            <a href="https://www.instagram.com/" class="btn btn--small"><img src="/media/images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>

<script src="/media/js/app.js"></script>

</body>
</html>
