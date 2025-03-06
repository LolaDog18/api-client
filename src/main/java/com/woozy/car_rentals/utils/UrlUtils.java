package com.woozy.car_rentals.utils;

import com.woozy.car_rentals.constants.Source;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UrlUtils {
    public static String getBasePathFor(Source source) {
        var basePath = System.getProperty("basePath");

        if (!basePath.isEmpty()) {
            return basePath + source.getName();
        } else {
            throw new RuntimeException("Base path has not been configured");
        }
    }
}
