package com.woozy.car_rentals.clients.implementation;

import io.restassured.RestAssured;

public abstract class BaseRestAssuredClient {
    static {
        var baseUri = System.getProperty("baseUri");

        if (!baseUri.isEmpty()) {
            RestAssured.baseURI = baseUri;
        } else {
            throw new RuntimeException("Base URI has not been configured");
        }
    }
}
