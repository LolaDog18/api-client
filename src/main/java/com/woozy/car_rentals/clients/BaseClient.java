package com.woozy.car_rentals.clients;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseClient {
    protected String baseUri;
    protected String basePath;
}
