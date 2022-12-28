::   Post data
curl -X POST http://127.0.0.1:8080/todo/ ^
-H "Content-Type: application/json" ^
-d "{ \"memo\":\"message 1\" }"

curl -X POST http://127.0.0.1:8080/todo/ ^
-H "Content-Type: application/json" ^
-d "{ \"memo\":\"message 2\" }"

curl -X POST http://127.0.0.1:8080/todo/ ^
-H "Content-Type: application/json" ^
-d "{ \"memo\":\"message 3\" }"

::   Query all Data
curl -X GET http://127.0.0.1:8080/todo/

::   Query single data
curl -X GET http://127.0.0.1:8080/todo/1

::   Do complex operation query (connect Redis, MySQL and remote serivce)
curl -X GET http://127.0.0.1:8080/todo/complex_operation


