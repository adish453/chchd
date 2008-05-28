package edu.chc.helpdesk.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DropDownListServiceTest {

    @Test
    public void testGetIssueDropDownList() {
        DropDownListService listService = new DropDownListService();
        assertEquals(1, listService.getIssueDropDownList().size());
    }

}
