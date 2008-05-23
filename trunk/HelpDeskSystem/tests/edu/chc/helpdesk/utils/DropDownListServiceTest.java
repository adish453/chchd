package edu.chc.helpdesk.utils;

import org.junit.Test;

import edu.chc.helpdesk.requests.DropDownValue;
import static org.junit.Assert.*;

public class DropDownListServiceTest {
	
	@Test
	public void testGetIssueDropDownList() {
		DropDownListService listService = new DropDownListService();
		assertEquals(0, listService.getIssueDropDownList().size());
	}

}
