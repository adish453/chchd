package edu.chc.helpdesk.email;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.chc.helpdesk.requests.HelpRequest;

public class MessageTest {

    @Before
    public void setUp() {

        //TODO Create a new HelpRequest Object with dummy values
        //TODO Create a new message object and pass in the HelpRequest Object

    }

    @After
    public void tearDown() {
        request = null;
        message = null;
    }

    @Test(expected = MessageNotValidException.class)
    public void testFailsafe() {
        //TODO Test throwing a MessageNotValidException
        fail("Not yet implemented");
    }

    @Test
    public void testGetBody() {
        //TODO Test getBody()
        fail("Not yet implemented");
    }

    @Test
    public void testGetFrom() {
        //TODO Test getFrom()
        fail("Not yet implemented");
    }

    @Test
    public void testGetSubject() {
        //TODO Test getSubject()
        fail("Not yet implemented");
    }

    @Test
    public void testGetTo() {
        //TODO Test getTo()
        fail("Not yet implemented");
    }

    @Test
    public void testSend() {
        //TODO Test send()
        fail("Not yet implemented");
    }

    HelpRequest request;

    Message message;

}
