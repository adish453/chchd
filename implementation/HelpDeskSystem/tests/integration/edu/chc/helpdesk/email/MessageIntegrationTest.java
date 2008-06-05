package edu.chc.helpdesk.email;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.chc.helpdesk.requests.HelpRequest;

import java.util.Date;

public class MessageIntegrationTest {
    
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
    
    @Test
    public void testGetBodyTech() {
        String newline = System.getProperty("line.separator");
        String expected = "Date Submitted: 8:53 AM, November 11, 2008" + newline +
                          "Submitted by: Visher, Tim" + newline +
                          "Location: Martino Hall, Room 314" + newline +
                          "Phone: 555-555-5555" + newline +
                          "E-Mail: user@needshelp.com" + newline +
                          "Issue: E-Mail" + newline + 
                          "Additional Comments: " + newline + newline + 
                          "This is a testing comment.";
        try {
            assertEquals(expected, message.getBody(MessageType.TECH));
        } catch (MessageNotValidException e) {
            fail("Unexpected MessageNotValidException.");
        }
    }
    
    @Test
    public void testGetSubjectTech() {
        String expected = "Help Request for E-Mail from Tim Visher";
        try {
            assertEquals(expected, message.getSubject(MessageType.TECH));
        } catch (MessageNotValidException e) {
            fail("Unexpected MessageNotValidException.");
        }
    }
    
    HelpRequest request;
    
    Message message;
    
}
