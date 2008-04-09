package edu.chc.helpdesk.requests;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.chc.helpdesk.model.HelpRequest;

@Stateless
public class HelpRequestBean implements HelpRequestFacade {

	@PersistenceContext(name="CHCHelpDeskDataModel")
	private EntityManager em;
	
	public void addRequest(HelpRequest request) {
		em.persist(request);
	}

	public List<HelpRequest> getAllRequests() {
		// TODO Auto-generated method stub
		List<HelpRequest> tmpList;
		tmpList = em.createNamedQuery("getAllRequests")
					.getResultList();
		return tmpList;
	}

	public HelpRequest getRequest(int requestID) {
		// TODO Throw exception if not found?
		return em.find(HelpRequest.class, requestID);
	}

	public void updateRequest(HelpRequest request) {
		// TODO Auto-generated method stub
		em.merge(request);
	}

}
