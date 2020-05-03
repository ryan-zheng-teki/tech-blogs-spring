# Introduction
The server we use is implemented by GraphQL. GraphQL is basically replacing our traditional multiple
restful endpoints with only one end point.  /graphql. GraphQL provides to us is a facade layer which 
we could directly interface with service layer. This saves us the need of writting more codes.


# Preparation

##In intellij, install the 
Step 1: Install lombok annotation preprocessor by following this guide
https://www.baeldung.com/lombok-ide

Step 2: Before running the application, execute the following command first. We are using QueryDSL. So we need to 
generate the neccessary classes first.

mvn clean generate-sources




# How to use
When the server is started up, you could access the endpoint by localhost:8080/graphiql to see what queries and mutations
that the server is providing.
