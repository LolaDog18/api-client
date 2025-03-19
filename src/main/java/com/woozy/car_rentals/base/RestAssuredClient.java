package com.woozy.car_rentals.base;

import com.woozy.car_rentals.config.filters.CustomLoggingFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class RestAssuredClient {
    static {
        RestAssured.filters(new CustomLoggingFilter());
    }

    public static Response executeGet(RequestSpecification requestSpecification) {
        return given(requestSpecification).get();
    }

    public static Response executePost(RequestSpecification requestSpecification) {
        return given(requestSpecification).post();
    }

    public static Response executePut(RequestSpecification requestSpecification) {
        return given(requestSpecification).put();
    }

    public static Response executeDelete(RequestSpecification requestSpecification) {
        return given(requestSpecification)
                .delete();
    }
}
