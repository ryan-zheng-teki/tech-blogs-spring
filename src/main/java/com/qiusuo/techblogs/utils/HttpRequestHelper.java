package com.qiusuo.techblogs.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class HttpRequestHelper {
    public static HttpRequest constructGetRequest(String endPoint, String requestPath, Map<String, String> pathParams, String token) {
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.GET();

        builder.uri(URI.create(endPoint));
        builder.setHeader("Authorization", String.format("Bearer %s", token));
        HttpRequest request = builder
                .build();
        return request;
    }


    public static HttpRequest constructPostRequest(String endPoint, String requestBody, Map<String, String> requestParams, Map<String, String> headers) {
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.POST(HttpRequest.BodyPublishers.ofString(requestBody));

        StringBuilder sb = new StringBuilder();
        requestParams.forEach((key, value) -> sb.append(key).append("=").append(value).append("&"));
        builder.uri(URI.create(endPoint + "?" + sb.deleteCharAt(sb.length() - 1).toString()));
        headers.forEach(builder::setHeader);

        HttpRequest request = builder
                .build();
        return request;
    }

    private static String replacePlaceHolders(String requestPath, Map<String, String> pathParams) {
        String replacedPathValue = requestPath;
        for (Map.Entry<String, String> entry : pathParams.entrySet()) {
            replacedPathValue = replacedPathValue.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return replacedPathValue;
    }

    public static String send(HttpRequest request) throws QiuSuoException {
        final HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        try {
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 401 || response.statusCode() == 403 || response.statusCode() == 404 || response.statusCode() == 500) {
                throw new QiuSuoException(response.body());
            }
            return response.body();
        } catch (IOException e) {
            throw new QiuSuoException(e.getMessage());
        } catch (InterruptedException e) {
            throw new QiuSuoException(e.getMessage());
        }

    }
}
