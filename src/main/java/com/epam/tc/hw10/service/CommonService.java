package com.epam.tc.hw10.service;

import com.epam.tc.hw10.utils.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonService {
    protected static String URI = "https://api.trello.com";
    protected static String BOARDS = "/1/boards/";
    protected static String LISTS = "/1/lists/";
    protected static String MEMBERS = "/members";

    public RequestSpecification requestSpecification() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return new RequestSpecBuilder()
            .setBaseUri(URI)
            .setContentType(ContentType.JSON)
            .addQueryParam("key", PropertiesReader.getProperty("apiKey"))
            .addQueryParam("token", PropertiesReader.getProperty("apiToken"))
            .build();
    }
}
