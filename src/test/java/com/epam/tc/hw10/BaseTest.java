package com.epam.tc.hw10;

import com.epam.tc.hw10.assertions.BoardAssertions;
import com.epam.tc.hw10.entities.Board;
import com.epam.tc.hw10.service.BoardService;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public Board board;
    public final BoardService boardService = new BoardService();
    public Map<String, String> params = new HashMap<>();
    public BoardAssertions ba = new BoardAssertions();

    @BeforeTest
    public void createABoard() {
        params.put("name", Board.NAME);
        board = boardService.createBoard(params);
        ba.verifyBoardName(board, Board.NAME);
    }

    @AfterTest
    public void deleteABoard() {
        Response rs = boardService.deleteBoard(board.getId());
        ba.verifyBoardDeletedResponse(rs);
    }
}
