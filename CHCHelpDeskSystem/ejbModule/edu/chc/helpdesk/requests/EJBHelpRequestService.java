package edu.chc.helpdesk.requests;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import edu.chc.helpdesk.email.Message;
import edu.chc.helpdesk.email.MessageNotValidException;
import edu.chc.helpdesk.email.MessageType;

@Stateless
public class EJBHelpRequestService implements HelpRequestService {

	// Should this throw HelpRequestNotValidException as a checked exception? 
	// Maybe the presentation layer should handle the exception by mapping
	// exceptions to error pages in faces-config.xml
	public void submit(HelpRequest request) throws HelpDeskApplicationException {

		if (!request.isValid()) {
			throw new HelpRequestNotValidException();
		}
		try {
			em.persist(request);
		} catch (PersistenceException pe) {
			//TODO Use the Logging API
			throw new HelpRequestSaveException("Request was not submitted due to a database error.");
		} catch (Exception e) {
			//TODO Use the Logging API
			throw new HelpRequestSaveException("Request was not submitted. A fatal error occurred.");
		}
		
		Message msg = new Message(request);
		
		try {
			msg.send(MessageType.CUSTOMER);
			msg.send(MessageType.TECH);
		} catch (MessageNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// injected resource for database access
	@PersistenceContext(name = "CHCHelpDeskDB")
	private EntityManager em;

}
