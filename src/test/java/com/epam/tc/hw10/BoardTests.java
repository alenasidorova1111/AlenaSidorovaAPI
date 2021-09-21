package com.epam.tc.hw10;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import com.epam.tc.hw10.entities.Board;
import com.epam.tc.hw10.service.BoardService;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class BoardTests {

    Response rs;
    Board board;
    BoardService boardService = new BoardService();
    Map<String, String> params = new HashMap<>();

    @Test(description = "Create and delete board test")
    public void createAndDeleteBoardTest() {
        params.put("name", "My new board");
        board = boardService.createBoard(params);

        assertEquals(board.getName(), "My new board");

        rs = boardService.deleteBoard(board.getId());

        assertNull(rs.path("_value"));
    }

    @Test(description = "Create, get and delete board test")
    public void createGetDeleteBoardTest() {
        params.put("name", "My new board");
        String boardID = boardService.createBoard(params).getId();

        board = boardService.getBoard(boardID);

        assertEquals(board.getName(), "My new board");

        rs = boardService.deleteBoard(board.getId());

        assertNull(rs.path("_value"));
    }

    @Test(description = "Create, update and delete board test")
    public void createUpdateDeleteBoardTest() {
        params.put("name", "My new board");
        String boardID = boardService.createBoard(params).getId();

        params.put("name", "My old board");
        board = boardService.updateBoard(boardID, params);

        assertEquals(board.getName(), "My old board");

        boardService.deleteBoard(board.getId());

    }

}
