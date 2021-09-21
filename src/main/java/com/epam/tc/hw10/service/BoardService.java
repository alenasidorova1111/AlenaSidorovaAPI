package com.epam.tc.hw10.service;

import static io.restassured.RestAssured.given;

import com.epam.tc.hw10.entities.Board;
import com.google.gson.GsonBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;


public class BoardService extends CommonService{

    public Board parseBoard(Response rs) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(rs.getBody().asString(), Board.class);
    }

    public Board createBoard(Map<String, String> params) {
        Response rs = given()
            //.basePath(BOARDS)
            .spec(requestSpecification())
            .queryParams(params)
            .when().request(Method.POST, BOARDS)
            .then().statusCode(200).extract().response();

        return new GsonBuilder().excludeFieldsWithModifiers().create().fromJson(rs.getBody().asString(), Board.class);
    }

    public Response deleteBoard(String boardID) {
        Response rs = given()
            .spec(requestSpecification())
            .when().request(Method.DELETE, BOARDS + boardID)
            .then().statusCode(200).extract().response();

        return rs;
    }

    public Board getBoard(String boardID) {
        Response rs = given()
            .spec(requestSpecification())
            .when().request(Method.GET, BOARDS + boardID)
            .then().statusCode(200).extract().response();

        return new GsonBuilder().excludeFieldsWithModifiers().create().fromJson(rs.getBody().asString(), Board.class);

    }

    public Board updateBoard(String boardID, Map<String, String> params) {
        Response rs = given()
            .spec(requestSpecification())
            .queryParams(params)
            .when().request(Method.PUT, BOARDS + boardID)
            .then().statusCode(200).extract().response();

        return new GsonBuilder().excludeFieldsWithModifiers().create().fromJson(rs.getBody().asString(), Board.class);
    }
}
