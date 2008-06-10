package edu.chc.helpdesk.requests;

import java.util.List;

import edu.chc.helpdesk.utils.Criteria;

public class EJBHelpRequestServiceStub implements HelpRequestService {
	
	public void submit(HelpRequest request) throws HelpDeskApplicationException {
		// TODO Auto-generated method stub
	}

	public List<DropDownValue> getIssueDropDownList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DropDownValue> getLocationDropDownList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DropDownValue> getStatusDropDownList() {
		// TODO Auto-generated method stub
		return null;
	}

	public IssueDropDownValue getIssueById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public LocationDropDownValue getLocationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public StatusDropDownValue getStatusById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria getCriteriaObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
