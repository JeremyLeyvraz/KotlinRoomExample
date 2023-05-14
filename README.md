# KotlinRoomExamle

Simple application with two module: app and libraryExample.

## App
Simple application that use Compose and Hilt.
This application has a text field to enter a user name, and a button to add a user.
When the button is clicked, the user is added and the name is displayed in a list.

## libraryExample
Simple android module with 4 classes:
- AppDatabase: application database for Room.
- User: entity to describe an user.
- UserDao: data access object to define operation on the user.
- Module: Hilt module to use the dao in the application project.
