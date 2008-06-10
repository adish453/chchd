package edu.chc.helpdesk.email;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.chc.helpdesk.requests.HelpRequest;

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
    
    @Test
    public void testGetBodyCustomer() {
        String newline = System.getProperty("line.separator");
        String expected = "Thank you for contacting CHC Helpdesk.  Your request has been " + "received and will be processed shortly.  So we can more easily assist " + "you, please remember your case number and give it to the tech helping " + "you with this problem." + newline + newline + "Thank you and have a nice day." + newline + newline + "Case Number: 1";
        try {
            assertEquals(expected, message.getBody(MessageType.CUSTOMER));
        } catch (MessageNotValidException e) {
            fail("Unexpected MessageNotValidException");
        }
    }
    
    @Test
    public void testGetFrom() {
        assertEquals("helpdesk@chc.edu", message.getFrom());
    }
    
    @Test
    public void testGetHost() {
        assertEquals("mailhost.chc.edu", message.getHost());
    }
    
    @Test
    public void testGetSubjectCustomer() {
        try {
            assertEquals("Your Help Request (id 1) Has Been Received.", message.getSubject(MessageType.CUSTOMER));
        } catch (MessageNotValidException e) {
            fail("Unexpected MessageNotValidException.");
        }
    }
    
    @Test
    public void testGetToTech() {
        try {
            assertEquals("helpdesk@chc.edu", message.getTo(MessageType.TECH));
        } catch (MessageNotValidException e) {
            fail("Unexpected MessageNotValidException.");
        }
    }
    
    @Test
    public void testGetToCustomer() {
        try {
            assertEquals("user@needshelp.com", message.getTo(MessageType.CUSTOMER));
        } catch (MessageNotValidException e) {
            fail("Unexpected MessageNotValidException");
        }
    }
    
    @Test
    public void testIsValidTrueCustomer() {
        assertTrue(message.isValid(MessageType.CUSTOMER));
    }
    
    // TODO Test isValid(MessageType.TECH) in integration
    
    @Test
    public void testIsValidFalseCustomer() {
        // TODO Exercise isValid(MessageType.CUSTOMER) against an invalid
        // request
        fail("Not yet implemented.");
    }
    
    HelpRequest request;
    
    Message message;
    
}
