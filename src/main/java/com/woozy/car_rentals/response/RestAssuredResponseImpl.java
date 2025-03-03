package com.woozy.car_rentals.response;


import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class RestAssuredResponseImpl implements ClientResponse {
    private final Response response;

    @Override
    public <T> T extractBodyAs(Class<T> responseType) {
        return response.as(responseType);
    }

    @Override
    public int getStatusCode() {
        return response.getStatusCode();
    }

    @Override
    public Map<String, String> getHeaders() {
        Headers headers = response.getHeaders();
        Map<String, String> headersMap = new HashMap<>();
        headers.forEach(
                header -> {
                    headersMap.put(header.getName(), header.getValue());
                }
        );

        return headersMap;
    }
}
