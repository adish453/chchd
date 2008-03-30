/**
 * 
 */
package edu.chc.helpdesk.requests;

import javax.ejb.Remote;


/**
 * @author tim
 *
 */
@Remote
public interface HelpRequestService {
   
   //TODO 28-03-08 What parameters should be passed in?
   public boolean submitRequest();
   //TODO 28-03-08 Should we provide a way to get Requests?
   //public HelpRequest getRequest(ID);

}
