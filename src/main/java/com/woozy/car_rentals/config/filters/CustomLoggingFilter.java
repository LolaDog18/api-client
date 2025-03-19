package com.woozy.car_rentals.config.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomLoggingFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        log.info("REQUEST logged:");
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec);
        log.info("RESPONSE logged:");
        logResponse(response);
        return response;
    }

    private void logRequest(FilterableRequestSpecification requestSpec) {
        String requestDetails = String.format("Request - Method: %s, URI: %s, Headers: %s, Body: %s",
                requestSpec.getMethod(),
                requestSpec.getURI(),
                requestSpec.getHeaders(),
                requestSpec.getBody());

        log.info(requestDetails);
    }

    private void logResponse(Response response) {
        String responseDetails = String.format("Response - Status Code: %d, Headers: %s, Body: %s",
                response.getStatusCode(),
                response.getHeaders(),
                response.getBody().asString());

        log.info(responseDetails);
    }
}