package com.epam.tc.hw10;

import com.epam.tc.hw10.assertions.ListAssertions;
import com.epam.tc.hw10.entities.List;
import com.epam.tc.hw10.service.ListService;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class ListTests extends BaseTest{

    private List list;
    private ListAssertions la = new ListAssertions();
    private final ListService listService = new ListService();
    private Map<String, String> listParams = new HashMap<>();

    @Test(description = "Create list and delete board test")
    public void createListDeleteBoardTest() {
        listParams.put("name", List.NAME);
        listParams.put("idBoard", board.getId());
        list = listService.createList(listParams);

        la.verifyListName(list, List.NAME);
    }

    @Test(description = "Create, delete list and delete board test")
    public void createUpdateListDeleteBoardTest() {
        String changedName = "ToDo test list changed";
        listParams.put("name", List.NAME);
        params.put("idBoard", board.getId());

        list = listService.createList(listParams);
        String listID = list.getId();

        listParams.put("name", changedName);
        list = listService.updateList(listID, listParams);

        la.verifyListName(list, changedName);
    }
}
