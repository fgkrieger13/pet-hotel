# Spring Boot API Starter

## Getting Started

### DB SETUP
`application.properties` will need to be updated with your username, and or db name.
Check out the database.sql for getting pets to work.

### GRADLE WRAPPER
Install gradle if you haven't already with 'brew install gradle'. [Instructions here](https://gradle.org/install)

To start your server, type `gradle bootRun` in your terminal.

Go to: http://localhost:8080/pets/

Go to: application.properties username to name in your terminal.

You should see the hello greeting from the `HelloController` file for GET "/"

To stop, `control + c` (same as node)

### HTTP REQUESTS
Our POST request is not a true REST POST request. We were unable to close the loop by sending back a response so our postAllPets function is a GET request sending data through the URL instead of the body. 

Our GET request is correct and should work. Go to localhost8080/ when database is setup and server running to test.

Documentation can be inconsistent as their are so many different ways to setup a REST API with java. Keywords when doing research should include vsCode, Spring boot, java, and gradle.