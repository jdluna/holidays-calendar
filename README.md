# Holidays Calendar

[![Build Status](https://travis-ci.org/mcalegaro/holidays-calendar.svg?branch=master)](https://travis-ci.org/mcalegaro/holidays-calendar)

## Introduction
The project holidays-calendar provides REST services for create, update, delete and search for holidays dates organized by Country, State or County.

## Technologies
Built using maven, java 8, spring-boot 1.4.3, spring-boot-devtools, spring-data-mongodb, swagger 2 and lombok accessing NoSQL MongoDB 3.2. Tests with junit, RestAssured and embedded MongoDB.

## Travis CI (Continuous Integration)
Using Travis as CI accessing https://travis-ci.org/mcalegaro/holidays-calendar

## How start the project
mvn spring-boot:run

## How access the project
http://localhost:9090/

- GET     http://localhost:9090/holidays?idLocale=BR
- POST    http://localhost:9090/holidays?idLocale=BR
- POST    http://localhost:9090/locales
- GET     http://localhost:9090/locales/types
- GET     http://localhost:9090/locales/BR

## API RESTful
Using Swagger 2 to document the RESTFul API accessing http://localhost:9090/swagger-ui.html
