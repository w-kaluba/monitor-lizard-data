# Monitor Lizard Backend

## Setup
Requirements:
Maven - 3.6.3

Binance Java API - https://github.com/binance-exchange/binance-java-api

(Docker)

In order to build from source you need to build the Binance Java API and install it to your local .m2 repository.
You also need to configure a local instance of postgresql and add the sign in details to application.properties.
You can then run the server using the below commands. 
The server should be accessible at localhost:8080 with the GraphQL endpoint exposed at /graphql.

## Running the server
### Starting the server

`mvn spring-boot:start`

### Stopping the server

`mvn spring-boot:stop`
## TO-DO
1. Write the rest of the README
