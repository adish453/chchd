package edu.chc.helpdesk.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import com.sun.enterprise.admin.util.Logger;

import edu.chc.helpdesk.requests.Criteria;
import edu.chc.helpdesk.requests.DropDownValue;
import edu.chc.helpdesk.requests.HelpRequest;
import edu.chc.helpdesk.requests.HelpRequestService;
import edu.chc.helpdesk.utils.Expression;

public class BrowseRequestBean {
	
	private final int LIST_NONE = 0;
	
	@EJB
	protected HelpRequestService requestService;
	
	private String firstName;
	private String lastName;
	private String roomNo;
	
	private int location;
	private int problem;
	
	private List locationSelectItems;
	private List issueSelectItems;
	
	//search results are stored here
	private List<HelpRequest> searchResults;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the roomNo
	 */
	public String getRoomNo() {
		return roomNo;
	}

	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	/**
	 * @return the location
	 */
	public int getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(int location) {
		this.location = location;
	}

	/**
	 * @return the problem
	 */
	public int getProblem() {
		return problem;
	}

	/**
	 * @param problem the problem to set
	 */
	public void setProblem(int problem) {
		this.problem = problem;
	}
	
	public String search()
	{
		// this code probably should go in the business layer,
		// but this was quicker to implement
		Criteria c = requestService.getCriteriaObject();
		
		if(!isNullOrEmpty(firstName))
			c.add(Expression.like("firstName",firstName));
		if(!isNullOrEmpty(lastName))
			c.add(Expression.like("lastName", lastName));
		if(!isNullOrEmpty(roomNo))
			c.add(Expression.like("roomNumber", roomNo));
		if(location != LIST_NONE)
			c.add(Expression.equalTo("locationId", location));
		if(problem != LIST_NONE)
			c.add(Expression.equalTo("issueId", problem));

		Logger.log(c.getQueryString());
		searchResults = (List<HelpRequest>) c.list();
		
		return "success";
	}
	
	public String reset(){
		return "reset";
	}
	
	public List getLocationSelectItems() {
		if(locationSelectItems ==  null) {
			locationSelectItems = getSelectItemsForList(requestService.getLocationDropDownList());
		}
		return locationSelectItems;
	}
	
	public void setLocationSelectItems(List locationSelectItems)  {
		this.locationSelectItems = locationSelectItems;
	}
	
	public List getIssueSelectItems() {
		if(issueSelectItems == null){
			issueSelectItems = getSelectItemsForList(requestService.getIssueDropDownList());
		}
		return issueSelectItems;
	}
	
	public void setIssueSelectItems(List issueSelectItems)  {
		this.issueSelectItems = issueSelectItems;
	}
	
	private List getSelectItemsForList(List<? extends DropDownValue> valueList) {
		
		List selectItems = new ArrayList();
		
		//(none)
		selectItems.add(new SelectItem(LIST_NONE,""));
		
		for(DropDownValue value : valueList) {
			selectItems.add(new SelectItem(value.getID(),value.getDisplayValue()));
		}
		
		return selectItems;
	}

	/**
	 * @return the searchResults
	 */
	public List<HelpRequest> getSearchResults() {
		return searchResults;
	}

	/**
	 * @param searchResults the searchResults to set
	 */
	public void setSearchResults(List<HelpRequest> searchResults) {
		this.searchResults = searchResults;
	}
	
	public int getResultCount() {
		if(searchResults != null)
			return searchResults.size();
		else
			return 0;
	}

	private boolean isNullOrEmpty(String s) { 
		return (s==null || s==""); 
	}
}