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
			
			//Do we need to flush it?
			//the problem is we want to make sure the returned request
			//has it's ID field set, which will only happen after it gets
			//persisted to the database.
			
			//Actually there is a deeper issue here: there is only added-value
			//in returning the request if the returned request is different
			//from the passed-in request (i.e. the returned request
			//has its requestID field set to the value in the DB that resulted
			//from inserting the record.)
			//Otherwise, if we end up just returning an exact copy of the passed-in
			//request, there is no point in returning anything at all.
			
			em.flush();
			// the following line doesn't work, which implies that 
			//flush() doesn't actually write the record to the database
			//immediately, b/c refresh() fails with an error stating
			//that the request isn't in the database. so...maybe
			//flush() doesn't work when you use CMP since the container
			//is technically supposed to commit transactions?
			//
			//em.refresh(request);
			
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
