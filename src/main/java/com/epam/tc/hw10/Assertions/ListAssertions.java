package com.epam.tc.hw10.Assertions;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw10.entities.List;

public class ListAssertions {

    public void verifyListName(List list, String expected) {
        assertEquals(list.getName(), expected);
    }
}
