/**
 * 
 */
package edu.chc.helpdesk.requests;

/**
 * @author tav, mgs
 */
public interface HelpRequestService {

	// TODO 28-03-08 What parameters should be passed in?
	// TODO 10-04-08 Return a HelpRequest object to get it's ID?
	public int submit(HelpRequest request);

	// public void update(HelpRequest request);
	//    
	// // TODO 28-03-08 Should we provide a way to get Requests?
	// public HelpRequest get(int requestID);
	//    
	// public List<HelpRequest> getAll();

}
