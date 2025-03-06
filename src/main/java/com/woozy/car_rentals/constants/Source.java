package com.woozy.car_rentals.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Source {
    AUTH("/auth"),
    CUSTOMERS("/customers");

    private final String name;
}
