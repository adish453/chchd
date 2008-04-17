package edu.chc.helpdesk.requests;

public class EJBHelpRequestServiceStub implements HelpRequestService {
	
	boolean success;
	
	public EJBHelpRequestServiceStub(boolean success) {
		this.success = success;
	}

	public HelpRequest submit(HelpRequest request) throws HelpRequestNotValidException {
		// TODO Auto-generated method stub
		return null;
	}

}
