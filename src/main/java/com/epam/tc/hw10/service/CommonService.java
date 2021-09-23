package com.epam.tc.hw10.service;

import static io.restassured.RestAssured.given;

import com.epam.tc.hw10.utils.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class CommonService {
    protected static String URI = "https://api.trello.com";
    protected static String BOARDS = "/1/boards/";
    protected static String LISTS = "/1/lists/";

    public RequestSpecification requestSpecification() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return new RequestSpecBuilder()
            .setBaseUri(URI)
            .setContentType(ContentType.JSON)
            .addQueryParam("key", PropertiesReader.getProperty("apiKey"))
            .addQueryParam("token", PropertiesReader.getProperty("apiToken"))
            .build();
    }

    public Response requestWithNoParams(Method method, String path) {
        return
            given().spec(requestSpecification()).when().request(method, path)
                   .then().statusCode(200).extract().response();
    }

    public Response requestWithParams(Method method, String path, Map<String, String> params) {
        return
            given().spec(requestSpecification()).queryParams(params).when().request(method, path)
                   .then().statusCode(200).extract().response();
    }

}
