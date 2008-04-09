/**
 * 
 */
package edu.chc.helpdesk.requests;

/**
 * @author tim
 *
 */

//FIXME Move this interface to CHCHelpDeskDataModel project
//FIXME Remame to HelpDeskFacade

interface HelpRequest {
   
   /**
    * <p>Provides a way to make sure that the HelpRequest is valid.</p>
    * @return <p>Whether or not this HelpRequest Object is internally valid.</p>
    */
   public boolean isValid();
   
   /**
    * <p>Call to persist this object</p>
    * @return <p>Whether or not this HelpRequest object was persisted.</p>
    */
   public boolean save();

}
