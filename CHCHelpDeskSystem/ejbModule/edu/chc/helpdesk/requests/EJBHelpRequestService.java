package edu.chc.helpdesk.requests;

import java.io.*;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class EJBHelpRequestService implements HelpRequestService {

	// injected resource for database access
	@PersistenceContext(name="CHCHelpDeskDB")
	private EntityManager em;

	// Should this throw HelpRequestNotValidException as a checked exception? 
	// Maybe the presentation layer should handle the exception by mapping
	// exceptions to error pages in faces-config.xml
	public HelpRequest submit(HelpRequest request) 
		throws HelpDeskApplicationException
	{
		
		//if(!request.isValid())
		//	throw new HelpRequestNotValidException();	
		try
		{
			em.persist(request);
			return request;
		}
		catch(PersistenceException pe)
		{
			//we should log the real exception somewhere,
			//otherwise debugging will be *really* hard
			System.out.print(pe.getMessage());
			throw new HelpRequestSaveException("Request was not submitted due to a database error.");
		}
		catch(Exception e)
		{
			//we should log the real exception somewhere,
			//otherwise debugging will be *really* hard
			System.out.print(e.getMessage());
			throw new HelpRequestSaveException("Request was not submitted. A fatal error occurred.");
		}

	}
	
}
