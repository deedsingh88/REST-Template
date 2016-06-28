Replace the server and port number
GET all user http://localhost:8080/rest-template/service/User

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

JSON response :
{
  "username": "deedsing",
  "firstname": "Deed",
  "lastname": "Singh"
}

PUT update User GET a user http://localhost:8080/rest-template/service

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
JSON response : HTTP OK
Error Messages

{
  "error": "NOT_FOUND",
  "message": "User deedsingg does not exist "
}

{
  "error": "BAD_REQUEST",
  "message": "User Data not structured properly "
}
