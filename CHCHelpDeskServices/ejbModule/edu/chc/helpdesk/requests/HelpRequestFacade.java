/**
 * 
 */
package edu.chc.helpdesk.requests;

import edu.chc.helpdesk.requests.HelpRequest;
import java.util.List;

/**
 * @author tim
 *
 */

//FIXME Recommand renaming this to HelpRequestFacade
//FIXME add isValid() method to this interface & mark as private
public interface HelpRequestFacade {
   
   //TODO 28-03-08 What parameters should be passed in?
   public void addRequest(HelpRequest request);
   
   public void updateRequest(HelpRequest request);
   
   //TODO 28-03-08 Should we provide a way to get Requests?
   public HelpRequest getRequest(int requestID);
   
   public List<HelpRequest> getAllRequests();

}
