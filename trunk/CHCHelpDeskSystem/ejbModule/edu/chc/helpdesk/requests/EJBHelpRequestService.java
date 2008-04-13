package edu.chc.helpdesk.requests;

import javax.ejb.Stateless;

@Stateless
public class EJBHelpRequestService implements HelpRequestService {

	public HelpRequest submit(HelpRequest request) throws HelpRequestNotValidException {
		// TODO Auto-generated method stub
		return request;
	}

}
