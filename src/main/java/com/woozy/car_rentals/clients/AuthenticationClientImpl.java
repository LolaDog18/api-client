package com.woozy.car_rentals.clients;

import com.woozy.AuthenticationRequestDto;
import com.woozy.RegisterCustomerRequestDto;
import com.woozy.car_rentals.base.RestAssuredClient;
import com.woozy.car_rentals.response.ClientResponse;
import com.woozy.car_rentals.response.RestAssuredResponseImpl;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class AuthenticationClientImpl extends BaseClient implements AuthenticationClient {
    private RequestSpecification spec;

    public AuthenticationClientImpl(String baseUri, String basePath) {
        super(baseUri, basePath);

        if (!baseUri.isEmpty()) RestAssured.baseURI = baseUri;
        if (!basePath.isEmpty()) RestAssured.basePath = basePath + "/auth";
    }

    @Override
    public ClientResponse registerCustomer(RegisterCustomerRequestDto registerCustomerDto) {
        prepareRequestSpec(registerCustomerDto);
        return new RestAssuredResponseImpl(RestAssuredClient.executePost("/register-customer", spec));
    }

    @Override
    public ClientResponse authenticateCustomer(AuthenticationRequestDto authenticationCustomerDto) {
        prepareRequestSpec(authenticationCustomerDto);
        return new RestAssuredResponseImpl(RestAssuredClient.executePost("/authenticate", spec));
    }

    private <T> void prepareRequestSpec(T requestDto) {
        spec = new RequestSpecBuilder().build();
        spec.body(requestDto)
                .contentType(APPLICATION_JSON.getMimeType());
    }
}
