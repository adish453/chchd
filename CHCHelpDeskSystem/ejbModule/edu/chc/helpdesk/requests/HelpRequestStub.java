/**
 * 
 */
package edu.chc.helpdesk.requests;

/**
 * @author tim
 * 
 */

public class HelpRequestStub extends HelpRequest {

	/**
	 * <p>
	 * Stub implementation for testing purposes.
	 * </p>
	 * 
	 * @return true
	 *         <p>
	 *         For testing purposes.
	 *         </p>
	 * @see edu.chc.helpdesk.requests.HelpRequest#isValid()
	 */
	@Override
	public boolean isValid() {
		return true;
	}

	/**
	 * <p>
	 * Stub implementation for testing purposes
	 * </p>
	 * 
	 * @return true
	 *         </p>
	 *         For tesing purposes
	 *         </p>
	 * @see edu.chc.helpdesk.requests.HelpRequest#save()
	 */
	public boolean save() {
		return true;
	}

}
