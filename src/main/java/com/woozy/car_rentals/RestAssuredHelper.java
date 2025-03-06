package com.woozy.car_rentals;

import io.restassured.builder.RequestSpecBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.entity.ContentType;

import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestAssuredHelper {
    public static RequestSpecBuilder buildCommonSpecBuilder(String basePath,
                                                            Map<String, String> pathParams,
                                                            Map<String, String> queryParams,
                                                            Map<String, String> formParam,
                                                            ContentType contentType,
                                                            Object body) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();

        Optional.ofNullable(basePath)
                .filter(bp -> !bp.isEmpty())
                .ifPresent(specBuilder::setBasePath);

        Optional.ofNullable(pathParams)
                .ifPresent(params -> params.forEach(specBuilder::addPathParam));

        Optional.ofNullable(queryParams)
                .ifPresent(params -> params.forEach(specBuilder::addQueryParam));

        Optional.ofNullable(formParam)
                .ifPresent(params -> params.forEach(specBuilder::addFormParam));

        Optional.ofNullable(body).ifPresent(specBuilder::setBody);
        Optional.ofNullable(contentType).ifPresent(ct -> specBuilder.setContentType(ct.getMimeType()));
        return specBuilder;
    }
}
