/**
 * 
 */
package edu.chc.helpdesk.requests;

/**
 * @author tav, mgs
 */
public interface HelpRequestService {

	public void submit(HelpRequest request) throws HelpDeskApplicationException;
}
