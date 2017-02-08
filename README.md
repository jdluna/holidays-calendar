# Holidays Calendar
[![Build Status](https://travis-ci.org/mcalegaro/holidays-calendar.svg?branch=master)](https://travis-ci.org/mcalegaro/holidays-calendar)

**The project holidays-calendar provides REST services for create, update, delete and search for holiday dates organized by Country, State or County.**

## Travis CI (Continuous Integration)
Using Travis as CI accessing https://travis-ci.org/mcalegaro/holidays-calendar

## Technologies
Built using maven, java 8, spring-boot 1.4.3, spring-boot-devtools, spring-data-mongodb, swagger 2 and lombok accessing NoSQL MongoDB 3.2. Tests with junit, RestAssured and embedded MongoDB.

## How to start the project
mvn spring-boot:run

## How to access the project
http://localhost:9090/

- GET     http://localhost:9090/holidays?idLocale=BR
- POST    http://localhost:9090/holidays?idLocale=BR
- POST    http://localhost:9090/locales
- GET     http://localhost:9090/locales/types
- GET     http://localhost:9090/locales/BR

## API RESTful
Using Swagger UI 2 to document the RESTFul API accessing http://localhost:9090/swagger-ui.html
