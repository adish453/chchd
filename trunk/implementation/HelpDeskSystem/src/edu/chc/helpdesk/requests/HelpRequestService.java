package edu.chc.helpdesk.requests;

import java.util.List;

import edu.chc.helpdesk.utils.Criteria;

/**
 * @author tav, mgs
 */
public interface HelpRequestService {

	public void submit(HelpRequest request) throws HelpDeskApplicationException;

	public List<DropDownValue> getLocationDropDownList();
	public List<DropDownValue> getStatusDropDownList();
	public List<DropDownValue> getIssueDropDownList();
	public LocationDropDownValue getLocationById(int id);
	public IssueDropDownValue getIssueById(int id);
	public StatusDropDownValue getStatusById(int id);
	public Criteria getCriteriaObject();
}
