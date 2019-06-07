# Giveaway
![giveaway1](https://user-images.githubusercontent.com/47396707/59097937-25a3e400-891f-11e9-9f79-33d40025875e.jpg)

## Introduction
An application where you can give unused things to charities and foundations. The idea was that to encourage everyone to help homeless, poor, disabled people giving things like clothes, food etc. to charities and foundations. User can create a new gift choosing what kind of things would like to give, amount, town, which group would like to support, available institution from institution list, address and date of receipt. There is an admin panel where you can manage admins, users, institutions and gifts.

Photo

## Technologies
- Java
- Spring Boot
- Spring Security
- Hibernate
- HTML
- JSP
- CSS
- Bootstrap

## Functionalities 
- Registration
- Login
- Editing profile
- Creating new gift
- Gifts archiving
- Sending email to activate user account
- Sending password reset link
- Admins, users, institutions and gifts managing using admin panel

## Database structure
<p align="center">
  <img width="590" height="830" src="https://user-images.githubusercontent.com/47396707/59100401-3ad04100-8926-11e9-90a8-fc877f8c830c.jpg">
</p>

## Before start
Before run an application create database "giveaway" or use your own database. If you want to use your own database please change database name in file "application.properties" inside resources directory. You should use these queries too before start:

To create roles:  
`INSERT INTO roles (role) VALUES ("ROLE_USER"), ("ROLE_ADMIN");`   
To add locations:  
`INSERT INTO locations (name) VALUES ("Gdańsk"), ("Wrocław"), ("Warszawa");`  - you can use your own values  
To add institution:  
`INSERT INTO institutions (name) VALUES ("Fundacja 'Hades'"), ("Fundacja 'Star Wars'"), ("Fundacja 'Avengers'");`   - you can use your own values  
  
The first registered user will be an admin. You can add new admins, users, institutions via admin panel after logging in.









