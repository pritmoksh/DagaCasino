
### Setup

1. Run the service

2. Web interface for H2 database
Launch : http://localhost:8080/h2/login.do?jsessionid=33c0cb9d649663b0545cde2a15a2d644

3. Run script found in Addplayers.sql



### Testing the service locally

Calling getPlayer endpoint : 

curl --location --request GET 'http://localhost:8080/players/balance/102' \
--header 'Cookie: Cookie_1=value'


Calling Wager endpoint : 

curl --location --request POST 'http://localhost:8080/players/wager' \
--header 'Content-Type: application/json' \
--header 'Cookie: Cookie_1=value' \
--data-raw '{"wager":80,
"playerId":102,
"transactionId":1,
"win": 1000}'
