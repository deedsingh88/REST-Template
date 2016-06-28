
README
----------------------
This is a REST template which demonstrate CRUD operations for a User object.
It also has JUNIT test cases and a REST client which can be used to invoke the service.


Maven Installation Instruction 
----------------------
Run command : mvn clean install
Note : Junit test cases are configured to use port 8000. If it is being used please modified the port in JUNIT test class 'src\test\java\com\deed\rest\UserEndpoint.java'


Deployment Instructions
----------------------
A war file will be generated in target folder (rest-template.war).
You need to deploy this war on your server.

REST URLS and their Response
----------------------

GET all user http://localhost:8080/rest-template/service/User
----------------------

JSON response :
{
  "deedsing": {
    "username": "deedsing",
    "firstname": "Deed",
    "lastname": "Singh"
  },
  "ajaygarg": {
    "username": "ajaygarg",
    "firstname": "Ajay",
    "lastname": "Garg"
  },
  "hanusing": {
    "username": "hanusing",
    "firstname": "OpenderDeep",
    "lastname": "Singh"
  }
}

GET a user http://localhost:8080/rest-template/service/User/deedsing
----------------------

JSON response :
{
  "username": "deedsing",
  "firstname": "Deed",
  "lastname": "Singh"
}

PUT update User GET a user http://localhost:8080/rest-template/service
----------------------

JSON request :
{
  "username": "deedsing",
  "firstname": "DeedSingh",
  "lastname": ""
}

JSON response :

{
  "username": "deedsing",
  "firstname": "DeedSingh",
  "lastname": ""
}

POST create a new user http://localhost:8080/rest-template/service/
----------------------

JSON request :
{
  "username": "deedsing",
  "firstname": "Deed",
  "lastname": "Singh"
}

JSON response :
{
  "username": "deedsing",
  "firstname": "Deed",
  "lastname": "Singh"
}

DELETE a user http://localhost:8080/rest-template/service/User/deedsing
----------------------
JSON response : HTTP OK


Custom Error Messages
----------------------

{
  "error": "NOT_FOUND",
  "message": "User deedsingg does not exist "
}

{
  "error": "BAD_REQUEST",
  "message": "User Data not structured properly "
}
