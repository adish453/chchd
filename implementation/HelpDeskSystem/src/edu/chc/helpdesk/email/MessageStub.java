/**
 * 
 */
package edu.chc.helpdesk.email;

import edu.chc.helpdesk.requests.HelpRequest;

/**
 * @author tim
 */
public class MessageStub extends Message {
    
    public MessageStub(HelpRequest request) {
        super(request);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see edu.chc.helpdesk.email.Message#send()
     */
    @Override
    public void send(MessageType type) throws MessageNotValidException {
    // TODO implement
    }
    
}
