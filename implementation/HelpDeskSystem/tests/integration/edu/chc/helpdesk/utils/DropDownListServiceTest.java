package edu.chc.helpdesk.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class DropDownListServiceTest {

    @Test
    public void testGetIssueDropDownList() {
        DropDownListService listService = new DropDownListService();
        assertEquals(3, listService.getIssueDropDownList().size());
    }
    
    @Test
    public void testGetIssueByID() {
        DropDownListService listService = new DropDownListService();
        assertEquals("Powerpoint", listService.getIssueByID(3));
    }
    
    @Test
    public void testBadGetIssueByID() {
        DropDownListService listService = new DropDownListService();
        assertEquals(null, listService.getIssueByID(5));
    }

}
