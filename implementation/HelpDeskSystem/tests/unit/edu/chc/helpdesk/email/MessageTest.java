package edu.chc.helpdesk.email;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.chc.helpdesk.requests.HelpRequest;

import java.util.Date;

public class MessageTest {
    
    @Before
    public void setUp() {
        
        request = new HelpRequest();
        request.setRequestID(1);
        request.setDateEntered(new Date(2008, 11, 11, 8, 53));
        request.setFirstName("Tim");
        request.setLastName("Visher");
        // TODO Set Location?
        request.setRoomNumber("314");
        request.setPhoneNumber("555-555-5555");
        // TODO Set Issue?
        request.setComments("This is a testing comment.");
        request.setEmailAddress("user@needshelp.com");
        message = new Message(request);
        
    }
    
    @After
    public void tearDown() {
        request = null;
        message = null;
    }
    
    HelpRequest request;
    
    Message message;
    
}
