package com.woozy.car_rentals.clients.implementation;

import com.woozy.AuthenticationRequestDto;
import com.woozy.RegisterCustomerRequestDto;
import com.woozy.car_rentals.RestAssuredHelper;
import com.woozy.car_rentals.base.RestAssuredClient;
import com.woozy.car_rentals.clients.interfaces.AuthenticationClient;
import com.woozy.car_rentals.constants.Source;
import com.woozy.car_rentals.response.ClientResponse;
import com.woozy.car_rentals.response.RestAssuredResponseImpl;
import com.woozy.car_rentals.utils.UrlUtils;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;
import org.apache.http.entity.ContentType;

@NoArgsConstructor
public class AuthRestAssuredClientImpl extends BaseRestAssuredClient implements AuthenticationClient {
    private static final String basePath = UrlUtils.getBasePathFor(Source.AUTH);

    @Override
    public ClientResponse registerCustomer(RegisterCustomerRequestDto registerCustomerDto) {
        return new RestAssuredResponseImpl(RestAssuredClient.executePost(
                buildSpec(basePath + "/register-customer", registerCustomerDto)));
    }

    @Override
    public ClientResponse authenticateCustomer(AuthenticationRequestDto authenticationCustomerDto) {
        return new RestAssuredResponseImpl(RestAssuredClient.executePost(
                buildSpec(basePath + "/authenticate", authenticationCustomerDto)));
    }

    private RequestSpecification buildSpec(String path, Object body) {
        return RestAssuredHelper.buildCommonSpecBuilder(path,
                null,
                null,
                null,
                ContentType.APPLICATION_JSON,
                body).build();
    }
}
