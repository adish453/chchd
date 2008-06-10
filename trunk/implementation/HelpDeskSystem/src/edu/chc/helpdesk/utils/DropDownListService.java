package edu.chc.helpdesk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tvishe01 Service for encapsulating JDBC calls to the DropDownValue
 *         table for populating GUI Drop Down Lists and Updating their values in
 *         the DB.
 */

public class DropDownListService {
    
    // TODO utilize JNDI available HelpDeskDS
    String driver = "org.apache.derby.jdbc.ClientDriver";
    String dbName = "HelpDeskDB";
    String connectionURL = "jdbc:derby://localhost:1527/" + dbName + ";user=HelpDeskApp;password=HelpDeskApp;create=true";
    
    public List<String> getIssueDropDownList() {
        List<String> issueList = new ArrayList<String>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionURL);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT DisplayValue FROM DropDownValue WHERE ListName='ISSUE'";
            ResultSet rs = stmt.executeQuery(query);
            rs.beforeFirst();
            while (rs.next()) {
                issueList.add(rs.getString("DisplayValue"));
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return issueList;
    }
    
    public String getIssueByID(int issueID) {
        String issue = "";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionURL);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT DisplayValue FROM DropDownValue WHERE ListName='ISSUE' AND ID=" + issueID;
            ResultSet rs = stmt.executeQuery(query);
            rs.beforeFirst();
            if (rs.next()) {
                issue = rs.getString("DisplayValue");
            } else {
                issue = null;
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return issue;
    }
    
}
