package edu.chc.helpdesk;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import edu.chc.helpdesk.requests.HelpRequest;
import edu.chc.helpdesk.requests.HelpRequestService;
import edu.chc.helpdesk.requests.LocationDropDownValue;

public class FrontPageBean {
	
	@EJB
	private HelpRequestService requestService;
	HtmlSelectOneMenu locationMenu;
	
	String firstName, lastName, email, bldg, phoneNumber, problem, roomNo;

	public String getfirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getBldg()
	{
		return bldg;
	}

	public void setBldg(String bldg)
	{
		this.bldg = bldg;
	}
	
	public String getRoomNo()
	{
			return roomNo;
	}
	
	public void setRoomNo(String roomNo)
	{
		this.roomNo = roomNo;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
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
	
	//location drop-down
	public HtmlSelectOneMenu getLocationMenu() {
		
		locationMenu = new HtmlSelectOneMenu();

		final List<LocationDropDownValue> locationList;
		locationList = requestService.getLocationDropDownList();
		
		final List list = new ArrayList();
		for(LocationDropDownValue l : locationList) {
			list.add(new SelectItem(l.getID(), l.getDisplayValue()));
		}
		
		final UISelectItems items = new UISelectItems();
		items.setValue(list);
		
		locationMenu.getChildren().add(items);
		return locationMenu;
	}
}
