package edu.chc.helpdesk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.chc.helpdesk.requests.DropDownValue;

/**
 * @author tvishe01 Service for encapsulating JDBC calls to the DropDownValue
 *         table for populating GUI Drop Down Lists and Updating their values in
 *         the DB.
 */

public class DropDownListService {
    
    public List<String> getIssueDropDownList() {
        List<String> issueList = new ArrayList<String>();
        // TODO utilize JNDI available HelpDeskDS
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String dbName = "HelpDeskDB";
        String connectionURL = "jdbc:derby://localhost:1527/" + 
            dbName + ";user=HelpDeskApp;password=HelpDeskApp;create=true";
        
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionURL);
            // TODO populate issueList with the result set of the following SQL
            // statement
            // select DISPLAYVALUE from DROPDOWNVALUE where LISTNAME is ISSUE;
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT DisplayValue FROM DropDownValue WHERE ListName LIKE 'ISSUE'");
            rs.beforeFirst();
            while (rs.next()) {
                issueList.add(rs.getString("DisplayValue"));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return issueList;
    }
    
}
