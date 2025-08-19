package com.example.tests.base;

import com.example.framework.core.RequestSpecFactory;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {

    @BeforeSuite
    public void setUpRequestSpec() {
        RestAssured.requestSpecification = RequestSpecFactory.get();
    }
}
