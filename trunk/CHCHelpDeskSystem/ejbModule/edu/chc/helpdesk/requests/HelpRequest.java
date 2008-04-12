/**
 * 
 */
package edu.chc.helpdesk.requests;

/**
 * @author tim
 *
 */

abstract class HelpRequest {
   
   /**
    * <p>Provides a way to make sure that the HelpRequest is valid.</p>
    * @return <p>Whether or not this HelpRequest Object is internally valid.</p>
    */
   abstract boolean isValid();

}
