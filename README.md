# Test technical task for the devadmin company

Keynotes:

Spring Web

Embedded H2 Database with initial filling: schema.sql and data.sql.

Postman API - https://go.postman.co/workspace/My-Workspace~90bdc7ac-424b-43cd-8acc-3a2d417fad02/collection/17929303-8a3195b1-1290-4e4d-9903-ca45d0950f3e?action=share&creator=17929303

Basic API tests are present.

Uses an empty MockEntity, since according to the task we have to connect to the database through only one method.
But Entity for default "city" table also exists.

Method POST ("/select") - select columns in a table in a database with JSON in body of the HTTP-request: string "tableName" and list of strings "columns" (e.g. ["id", "name", ...]).
Receives JSON in response with selected data (e.g. "1, Yekaterinburg, Chkalovsky;...").

Method POST ("/create") - create table in a database with JSON in body of the HTTP-request: string "tableName" and list of strings "columns" (e.g. ["id VARCHAR PRIMARY KEY", ...]).

Method POST ("/delete") - delete row in a table in a database with JSON in body of the HTTP-request: string "tableName" and string "condition" (e.g. ["id = 1"]).

Method POST ("/insert") - insert row in a table in a database with JSON in body of the HTTP-request: string "tableName" and list of strings "columns" (e.g. ["id", "name", ...]) and list of strings "values" (e.g ["3", "Amsterdam", ...]).