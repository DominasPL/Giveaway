<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 5/16/19
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="/media/css/style.css" />
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj Agata
                <ul class="dropdown">
                    <li><a href="/profile">Profil</a></li>
                    <li><a href="#">Ustawienia</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li><a href="/logout">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/about-service" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/about-us" class="btn btn--without-border">O nas</a></li>
            <li>
                <a href="/organizations" class="btn btn--without-border"
                >Fundacje i organizacje</a
                >
            </li>
            <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

        <h3>Ważne!</h3>
        <p>
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
        </p>
        <p>
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
        </p>
        <p>
            Jeśli wiesz komu chcesz pomóc, możesz wpisać nazwę tej organizacji w
            wyszukiwarce. Możesz też filtrować organizacje po ich lokalizacji
            bądź celu ich pomocy.
        </p>
        <p >
            Na podstawie Twoich kryteriów oraz rzeczy, które masz do oddania
            wybraliśmy organizacje, którym możesz pomóc. Wybierz jedną, do
            której trafi Twoja przesyłka.
        </p>
        <p>Podaj adres oraz termin odbioru rzeczy.</p>


<br><br><br><br>
<form:form method="post" modelAttribute="answers">
    <div>
        <h3>Zaznacz co chcesz oddać:</h3>

        <form:checkbox path="things" value="clothes-to-use"/>
        ubrania, które nadają się do ponownego użycia <br>


        <form:checkbox path="things" value="clothes-useless"/>
        ubrania, do wyrzucenia<br>

        <form:checkbox path="things" value="toys" />
        zabawki<br>

        <form:checkbox path="things" value="books" />
        książki<br>

        <form:checkbox path="things" value="other" />
        inne<br>
    </div>
    <div>
        <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

        Liczba 60l worków:
        <form:input path="amount"/> <br>
    </div>
    <div>
        <h3>Lokalizacja:</h3>

        <form:select itemValue="id" itemLabel="name"
                     path="location.id" items="${locations}"/> <br>

    </div>
    <div>
        <h4>Komu chcesz pomóc?</h4>
            <form:checkbox path="groups" value="dzieciom"/>
            Dzieciom <br>

           <form:checkbox path="groups" value="samotnym matkom"/>
            Samotnym matkom <br>

            <form:checkbox path="groups" value="bezdomnym"/>
            Bezdomnym <br>

            <form:checkbox path="groups" value="niepełnosprawnym"/>
            Niepełnosprawnym <br>

            <form:checkbox path="groups" value="osobom starszym"/>
            Osobom starszym <br>

    </div>
    <div>

        <h3>Wybierz organizacje, której chcesz pomóc:</h3>

        <form:radiobuttons itemValue="id" itemLabel="name"
                           path="institution.id" items="${institutions}"/> <br>
    </div>
    <div>

        <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

        <div class="form-section form-section--columns">
            <div class="form-section--column">
                <h4>Adres odbioru</h4>
                <div class="form-group form-group--inline">
                    <label> Ulica<form:input path="street"/> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label> Miasto  <form:input path="town"/> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label>
                        Kod pocztowy <form:input path="postalCode"/>
                    </label>
                </div>

                <div class="form-group form-group--inline">
                    <label>
                        Numer telefonu <form:input path="phoneNumber"/>
                    </label>
                </div>
            </div>

            <div class="form-section--column">
                <h4>Termin odbioru</h4>
                <div class="form-group form-group--inline">
                    <label> Data <input type="date" name="date" /> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label> Godzina <input type="time" name="time" /> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label>
                        Uwagi dla kuriera
                        <form:textarea path="comment"/>
                    </label>
                </div>
            </div>
        </div>

    </div>
        <input type="submit" value="Potwierdź">

        </form:form>

</body>
</html>