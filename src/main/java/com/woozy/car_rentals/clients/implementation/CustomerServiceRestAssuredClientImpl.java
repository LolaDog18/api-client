package com.woozy.car_rentals.clients.implementation;

import com.woozy.UpdateCustomerRequestDto;
import com.woozy.car_rentals.RestAssuredHelper;
import com.woozy.car_rentals.clients.interfaces.AuthenticationClient;
import com.woozy.car_rentals.clients.interfaces.CustomerServiceClient;
import com.woozy.car_rentals.constants.AuthMode;
import com.woozy.car_rentals.constants.Source;
import com.woozy.car_rentals.response.ClientResponse;
import com.woozy.car_rentals.response.RestAssuredResponseImpl;
import com.woozy.car_rentals.utils.UrlUtils;
import io.restassured.specification.RequestSpecification;
import lombok.Setter;
import org.apache.http.entity.ContentType;

import java.util.Map;

import static com.woozy.car_rentals.base.RestAssuredClient.*;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

@Setter
public class CustomerServiceRestAssuredClientImpl extends BaseAuthenticationClient implements CustomerServiceClient {
    private AuthMode authMode = AuthMode.VALID;

    public CustomerServiceRestAssuredClientImpl(AuthenticationClient authClient) {
        super(authClient);
    }

    @Override
    public ClientResponse getCustomer(String userId) {
        var spec = buildSpec("/{userId}", Map.of("userId", userId), null, null, authMode);
        return new RestAssuredResponseImpl(executeGet(spec));
    }

    @Override
    public ClientResponse updateCustomer(String userId, UpdateCustomerRequestDto updateCustomerDto) {
        var spec = buildSpec("/{userId}", Map.of("userId", userId), APPLICATION_JSON, updateCustomerDto, authMode);
        return new RestAssuredResponseImpl(executePut(spec));
    }

    @Override
    public ClientResponse deleteCustomer(String userId) {
        var spec = buildSpec("/{userId}", Map.of("userId", userId), null, null, authMode);
        return new RestAssuredResponseImpl(executeDelete(spec));
    }

    private RequestSpecification buildSpec(String path, Map<String, String> pathParams, ContentType contentType, Object body, AuthMode authMode) {
        var basePath = UrlUtils.getBasePathFor(Source.CUSTOMERS) + path;
        var specBuilder = RestAssuredHelper.buildCommonSpecBuilder(basePath,
                pathParams,
                null,
                null,
                contentType,
                body);
        applyAuth(specBuilder, authMode);
        return specBuilder.build();
    }
}

