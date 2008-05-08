/**
 * 
 */
package edu.chc.helpdesk.requests;

import java.util.List;

/**
 * @author tav, mgs
 */
public interface HelpRequestService {

	public void submit(HelpRequest request) throws HelpDeskApplicationException;

	public List<LocationDropDownValue> getLocationDropDownList();
	public List<StatusDropDownValue> getStatusDropDownList();
	public List<IssueDropDownValue> getIssueDropDownList();
	public LocationDropDownValue getLocationById(String id);
	public IssueDropDownValue getIssueById(String id);
}
