package edu.chc.helpdesk.utils;

import java.util.ArrayList;
import java.util.List;

import edu.chc.helpdesk.requests.DropDownValue;

/**
 * 
 * @author tvishe01
 * 
 * Service for encapsulating JDBC calls to the DropDownValue table for populating 
 * GUI Drop Down Lists and Updating their values in the DB.
 *
 */

public class DropDownListService {

	public List<DropDownValue> getIssueDropDownList() {
		List<DropDownValue> issueList = new ArrayList<DropDownValue>();
		//TODO setup a jdbc connection the JNDI available HelpDeskDS
		//TODO populate issueList with the result set of the following SQL statement
			// select DISPLAYVALUE from DROPDOWNVALUE where LISTNAME is ISSUE;
		return issueList;
	}
	
	

}
