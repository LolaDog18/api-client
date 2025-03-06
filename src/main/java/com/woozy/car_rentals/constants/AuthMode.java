package com.woozy.car_rentals.constants;

import lombok.Getter;

@Getter
public enum AuthMode {
    NONE, VALID, INVALID;

    private String username;
    private String password;

    public static AuthMode VALID(String username, String password) {
        AuthMode mode = VALID;
        mode.username = username;
        mode.password = password;
        return mode;
    }

    public boolean isValid() {
        return this == VALID && username != null && password != null;
    }
}
