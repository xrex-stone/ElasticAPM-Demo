# Post data
curl --location --request POST 'http://127.0.0.1:8080/todo/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "memo":"message 1"
}'

curl --location --request POST 'http://127.0.0.1:8080/todo/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "memo":"message 2"
}'

curl --location --request POST 'http://127.0.0.1:8080/todo/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "memo":"message 3"
}'

# Query all Data
curl --location --request GET 'http://127.0.0.1:8080/todo/'

# Query single data
curl --location --request GET 'http://127.0.0.1:8080/todo/1'

# Do complex operation query (connect Redis, MySQL and remote serivce)
curl --location --request GET 'http://127.0.0.1:8080/todo/complex_operation'

