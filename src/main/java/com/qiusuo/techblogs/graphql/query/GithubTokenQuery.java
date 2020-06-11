package com.qiusuo.techblogs.graphql.query;

import com.qiusuo.techblogs.utils.HttpRequestHelper;
import com.qiusuo.techblogs.utils.QiuSuoException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class GithubTokenQuery implements GraphQLQueryResolver {
    @Value("${oauth_client_id}")
    private String client_id;

    @Value("${oauth_client_secret}")
    private String client_secret;

    @Value("${token_endpoint}")
    private String tokenEndpoint;

    public String githubToken(String code) throws QiuSuoException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);
        params.put("code", code);

        HttpRequest request = HttpRequestHelper.constructPostRequest(tokenEndpoint, "", params, headers);
        String result = HttpRequestHelper.send(request);
        if (result.contains("error")) {
            throw new QiuSuoException("GitHub Get AccessToken Error");
        }
        return result;
    }
}
