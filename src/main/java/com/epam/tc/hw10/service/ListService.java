package com.epam.tc.hw10.service;

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
        return parseList(requestWithParams(Method.POST, LISTS, params));
    }

    public List updateList(String listID, Map<String, String> params) {
        return parseList(requestWithParams(Method.PUT, LISTS + listID, params));
    }
}
