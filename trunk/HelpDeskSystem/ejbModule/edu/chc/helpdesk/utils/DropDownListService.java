package edu.chc.helpdesk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.chc.helpdesk.requests.DropDownValue;

/**
 * @author tvishe01 Service for encapsulating JDBC calls to the DropDownValue
 *         table for populating GUI Drop Down Lists and Updating their values in
 *         the DB.
 */

public class DropDownListService {
    
    public List<DropDownValue> getIssueDropDownList() {
        List<DropDownValue> issueList = new ArrayList<DropDownValue>();
        // TODO utilize JNDI available HelpDeskDS
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String dbName = "HelpDeskDB";
        String connectionURL = "jdbc:derby://localhost:1527/" + 
            dbName + ";user=HelpDeskApp;password=HelpDeskApp;create=true";
        
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionURL);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO populate issueList with the result set of the following SQL
        // statement
        // select DISPLAYVALUE from DROPDOWNVALUE where LISTNAME is ISSUE;
        return issueList;
    }
    
}
