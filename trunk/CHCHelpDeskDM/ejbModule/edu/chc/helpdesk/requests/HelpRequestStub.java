/**
 * 
 */
package edu.chc.helpdesk.requests;


/**
 * @author tim
 *
 */

// FIXME This class should implement HelpRequestFacade
public class HelpRequestStub implements HelpRequest {

   /**
    * <p>Stub implementation for testing purposes.</p>
    * @return true <p>For testing purposes.</p>
    * @see edu.chc.helpdesk.requests.HelpRequest#isValid()
    */
   public boolean isValid() {
      return true;
   }

   /**
    * <p>Stub implementation for testing purposes</p>
    * @return true </p>For tesing purposes</p>
    * @see edu.chc.helpdesk.requests.HelpRequest#save()
    */
   public boolean save() {
      return true;
   }

}
