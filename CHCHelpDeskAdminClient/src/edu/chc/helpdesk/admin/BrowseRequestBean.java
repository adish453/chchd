package edu.chc.helpdesk.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import edu.chc.helpdesk.requests.DropDownValue;
import edu.chc.helpdesk.requests.HelpRequestService;

public class BrowseRequestBean {
	
	@EJB
	protected HelpRequestService requestService;
	
	private String firstName;
	private String lastName;
	private String roomNo;
	
	private int location;
	private int problem;
	
	private List locationSelectItems;
	private List issueSelectItems;
	
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
		
		for(DropDownValue value : valueList) {
			selectItems.add(new SelectItem(value.getID(),value.getDisplayValue()));
		}
		
		return selectItems;
	}
}
