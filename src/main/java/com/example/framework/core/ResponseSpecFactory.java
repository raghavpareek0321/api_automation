package com.example.framework.core;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class ResponseSpecFactory {
    private static final ResponseSpecification OK_SPEC = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(3000L))
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification ok() {
        return OK_SPEC;
    }
}
