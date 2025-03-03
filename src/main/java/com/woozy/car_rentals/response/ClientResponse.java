package com.woozy.car_rentals.response;

import java.util.Map;

public interface ClientResponse {
    <T> T extractBodyAs(Class<T> responseType);

    int getStatusCode();

    Map<String, String> getHeaders();
}
