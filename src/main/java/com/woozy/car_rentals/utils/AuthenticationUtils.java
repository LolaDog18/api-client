package com.woozy.car_rentals.utils;

public abstract class AuthenticationUtils {
    private static final String BEARER_PREFIX = "Bearer ";

    public static String getBearerTokenHeader(String token) {
        return BEARER_PREFIX + token;
    }
}
