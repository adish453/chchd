package edu.chc.helpdesk;

import javax.ejb.EJB;

import edu.chc.helpdesk.requests.HelpRequest;
import edu.chc.helpdesk.requests.HelpRequestService;

public class FrontPageBean {
	
	@EJB
	private HelpRequestService requestService;
	
	String firstName, lastName, email, bldg, phoneNumber, problem, roomNo;

	public String getfirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		email = email;
	}

	public String getBldg()
	{
		return bldg;
	}

	public void setBldg(String location)
	{
		this.bldg = bldg;
	}
	
	public String getRoomNo()
	{
			return roomNo;
	}
	
	public void setRoomNo(String room)
	{
		roomNo = roomNo;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		phoneNumber = phoneNumber;
	}

	public String getProblem()
	{
		return problem;
	}

	public void setProblem(String problem)
	{
		this.problem = problem;
	}
	
	public String submit()
	{
		HelpRequest request = new HelpRequest();
		request.setFirstName(firstName);
		request.setLastName(lastName);
		request.setEmailAddress(email);
		request.setPhoneNumber(phoneNumber);

		
		
		return "success";
	}
	
	public String reset()
	{
		return "reset";
	}
}
