package edu.chc.helpdesk.requests;

public class HelpDeskApplicationException extends RuntimeException {
    
    public HelpDeskApplicationException() {
        super();
    }
    
    public HelpDeskApplicationException(String message) {
        super(message);
    }
}
