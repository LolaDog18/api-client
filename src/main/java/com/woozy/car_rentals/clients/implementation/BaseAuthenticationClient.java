package com.woozy.car_rentals.clients.implementation;

import com.woozy.AuthenticationRequestDto;
import com.woozy.AuthenticationResponseDto;
import com.woozy.car_rentals.clients.interfaces.AuthenticationClient;
import com.woozy.car_rentals.constants.AuthMode;
import com.woozy.car_rentals.utils.AuthenticationUtils;
import io.restassured.builder.RequestSpecBuilder;
import lombok.RequiredArgsConstructor;

import static org.apache.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public abstract class BaseAuthenticationClient extends BaseRestAssuredClient {
    protected final AuthenticationClient authClient;

    protected void applyAuth(RequestSpecBuilder specBuilder, AuthMode authMode) {
        if (authMode == AuthMode.NONE) return;

        String token = (authMode.isValid()) ? getValidToken(authMode.getUsername(), authMode.getPassword())
                : "Bearer invalid_token";
        specBuilder.addHeader(AUTHORIZATION, token);
    }

    private String getValidToken(String username, String password) {
        var authResponseDto = authClient.authenticateCustomer(
                        new AuthenticationRequestDto(username, password))
                .extractBodyAs(AuthenticationResponseDto.class);
        return AuthenticationUtils.getBearerTokenHeader(authResponseDto.getToken());
    }
}
