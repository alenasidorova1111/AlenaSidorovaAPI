package com.epam.tc.hw10.entities;

import lombok.Data;

@Data
public class List {
    private String id;
    private String name;
    private Boolean closed;
    private Integer pos;
    private String idBoard;
}
