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
    
    @Test
    public void testGetBodyCustomer() {
        //TODO Exercise getBody(MessageType.CUSTOMER)
        fail("Not yet implemented.");
    }
    
    @Test
    public void testGetFrom() {
        //TODO Exercise getFrom()
        fail("Not yet implemented.");
    }
    
    @Test
    public void testGetHost() {
        //TODO Exercise getHost()
        fail("Not yet implemented.");
    }
    
    @Test
    public void testGetSubjectCustomer() {
        //TODO Exercise getSubject(MessageType.CUSTOMER)
        fail("Not yet implemented.");
    }
    
    @Test
    public void testGetToTech() {
        //TODO Exercise getTo(MessageType.TECH)
        fail("Not yet implemented.");
    }
    
    @Test
    public void testGetToCustomer() {
        //TODO Exercise getTo(MessageType.CUSTOMER)
        fail("Not yet implemented.");
    }
    
    @Test
    public void testIsValidTrue() {
        //TODO Exercise isValid on Valid Request
        fail("Not yet implemented.");
    }
    
    @Test
    public void testIsValidFalse() {
        //TODO Exercise isValid on Invalid Request
        fail("Not yet implemented.");
    }
    
    HelpRequest request;
    
    Message message;
    
}
