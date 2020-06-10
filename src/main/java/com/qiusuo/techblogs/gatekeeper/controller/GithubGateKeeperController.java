package com.qiusuo.techblogs.gatekeeper.controller;

import com.qiusuo.techblogs.utils.HttpRequestHelper;
import com.qiusuo.techblogs.utils.QiuSuoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GithubGateKeeperController {
    @Value("${oauth_client_id}")
    private String client_id;

    @Value("${oauth_client_secret}")
    private String client_secret;

    @Value("${token_endpoint")
    private String tokenEndpoint;

    @RequestMapping("/github/accesstoken")
    public String authenticate(String authorizeCode) throws QiuSuoException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);
        params.put("code", authorizeCode);

        HttpRequest request = HttpRequestHelper.constructPostRequest(tokenEndpoint, "", params, headers);
        return HttpRequestHelper.send(request);
    }
}
