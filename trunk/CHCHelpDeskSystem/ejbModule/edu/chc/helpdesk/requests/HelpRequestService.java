/**
 * 
 */
package edu.chc.helpdesk.requests;

/**
 * @author tav, mgs
 */
public interface HelpRequestService {

	public HelpRequest submit(HelpRequest request) throws HelpRequestNotValidException;

}
