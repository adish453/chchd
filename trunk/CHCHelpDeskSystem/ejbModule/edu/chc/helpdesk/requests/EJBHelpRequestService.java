package edu.chc.helpdesk.requests;

import java.util.Date;
import java.util.List;

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
			
			//set the date for this request
			request.setDateEntered(new Date());
			//insert the request in the DB
			em.persist(request);
			//force JPA to insert the data into the DB right now
			em.flush();
			//reload the request from the DB (in order to get the auto-generated ID)
			em.refresh(request);
			
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
	
	public List<LocationDropDownValue> getLocationDropDownList() {
		List<LocationDropDownValue> results =
			em.createNamedQuery("getDropDownValuesForList")
			.setParameter("listName", "LOCATION")
			.getResultList();
		return results;
	}
	
	public List<StatusDropDownValue> getStatusDropDownList() {
		List<StatusDropDownValue> results =
			em.createNamedQuery("getDropDownValuesForList")
			.setParameter("listName", "STATUS")
			.getResultList();
		return results;
	}
	
	public List<IssueDropDownValue> getIssueDropDownList() {
		List<IssueDropDownValue> results =
			em.createNamedQuery("getDropDownValuesForList")
			.setParameter("listName", "ISSUE")
			.getResultList();
		return results;
	}

	public LocationDropDownValue getLocationById(int id) {
		return em.find(LocationDropDownValue.class, id);
	}
	
	public IssueDropDownValue getIssueById(int id) {
		return em.find(IssueDropDownValue.class, id);
	}
	
	public StatusDropDownValue getStatusById(int id) {
		return em.find(StatusDropDownValue.class, id);
	}

	// injected resource for database access
	@PersistenceContext(name = "CHCHelpDeskDB")
	private EntityManager em;

}
