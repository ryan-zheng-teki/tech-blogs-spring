package com.qiusuo.techblogs.domain.authentication;


/*
What we could do is that the user pass github id and access token to the backend.
Without comparing with the database, its not possible to really guard this method. Because once the api is found by
hacker, he could use any parameter to guard the backend.
We could use the authorizationCode as the password for this user. Or we could dynamically generate a unique token for this user.
*/
public class CustomAuthenticationProvider {

}
