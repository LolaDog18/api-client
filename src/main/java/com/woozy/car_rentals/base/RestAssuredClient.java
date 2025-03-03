package com.woozy.car_rentals.base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class RestAssuredClient {
    static {
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    }

    public static Response executeGet(RequestSpecification requestSpecification) {
        return given(requestSpecification).get();
    }

    public static Response executePost(String endpoint, RequestSpecification requestSpecification) {
        return given(requestSpecification).post(endpoint);
    }

    public static Response executePut(RequestSpecification requestSpecification) {
        return given(requestSpecification).post();
    }

    public static Response executeDelete(RequestSpecification requestSpecification) {
        return given(requestSpecification).delete();
    }
}
