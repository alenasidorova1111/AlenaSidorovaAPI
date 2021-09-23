package com.epam.tc.hw10.Assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import com.epam.tc.hw10.entities.Board;
import io.restassured.response.Response;

public class BoardAssertions {

    public void verifyBoardName(Board board, String expected) {
        assertEquals(board.getName(), expected);
    }

    public void verifyBoardDeletedResponse(Response response) {
        assertNull(response.path("_value"));
    }
}
