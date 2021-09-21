package com.epam.tc.hw10.service;

import static io.restassured.RestAssured.given;

import com.epam.tc.hw10.entities.Board;
import com.epam.tc.hw10.entities.List;
import com.google.gson.GsonBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class ListService extends CommonService{

    public List parseList(Response rs) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(rs.getBody().asString(), List.class);
    }

    public List createList(Map<String, String> params) {
        Response rs = given()
            .spec(requestSpecification())
            .queryParams(params)
            .when().request(Method.POST, LISTS)
            .then().statusCode(200).extract().response();

        return new GsonBuilder().excludeFieldsWithModifiers().create().fromJson(rs.getBody().asString(), List.class);
    }

    public List updateList(String listID, Map<String, String> params) {
        Response rs = given()
            .spec(requestSpecification())
            .queryParams(params)
            .when().request(Method.PUT, LISTS + listID)
            .then().statusCode(200).extract().response();

        return new GsonBuilder().excludeFieldsWithModifiers().create().fromJson(rs.getBody().asString(), List.class);
    }
}
