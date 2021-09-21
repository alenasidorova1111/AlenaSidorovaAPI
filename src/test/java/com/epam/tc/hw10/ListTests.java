package com.epam.tc.hw10;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw10.entities.List;
import com.epam.tc.hw10.service.BoardService;
import com.epam.tc.hw10.service.ListService;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class ListTests {

    List list;
    BoardService boardService = new BoardService();
    ListService listService = new ListService();
    Map<String, String> params = new HashMap<>();

    @Test(description = "Create list and delete board test")
    public void createListDeleteBoardTest() {
        params.put("name", "My new board");
        String boardID = boardService.createBoard(params).getId();

        params.put("name", "ToDoList");
        params.put("idBoard", boardID);
        list = listService.createList(params);

        assertEquals(list.getName(), "ToDoList");

        boardService.deleteBoard(boardID);
    }

    @Test(description = "Create, delete list and delete board test")
    public void createUpdateListDeleteBoardTest() {
        params.put("name", "My new board");
        String boardID = boardService.createBoard(params).getId();

        params.put("name", "ToDoList");
        params.put("idBoard", boardID);
        list = listService.createList(params);
        String listID = list.getId();

        params.put("name", "ToDoListChanged");
        list = listService.updateList(listID, params);

        assertEquals(list.getName(), "ToDoListChanged");

        boardService.deleteBoard(boardID);
    }
}
