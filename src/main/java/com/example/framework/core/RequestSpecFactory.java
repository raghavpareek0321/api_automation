package com.example.framework.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {
    private static final RequestSpecification REQUEST_SPEC;

    static {
        REQUEST_SPEC = new RequestSpecBuilder()
                .setBaseUri(Config.get("baseURI"))
                .setContentType(Config.get("contentType"))
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    public static RequestSpecification get() {
        return REQUEST_SPEC;
    }
}
