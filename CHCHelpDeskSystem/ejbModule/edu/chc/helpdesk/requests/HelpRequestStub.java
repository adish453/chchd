/**
 * 
 */
package edu.chc.helpdesk.requests;

import java.util.Date;

/**
 * @author tim
 * 
 */

public class HelpRequestStub extends HelpRequest {
	
	

	@Override
	public String getComments() {
		return "Fake Comments.";
	}

	@Override
	public Date getDateEntered() {
		return new Date();
	}

	@Override
	public String getEmailAddress() {
		return "fake@chc.edu";
	}

	@Override
	public String getFirstName() {
		return "Fakey";
	}

	@Override
	public IssueDropDownValue getIssueId() {
		return new IssueDropDownValue();
	}

	@Override
	public String getLastName() {
		return "Faker";
	}

	@Override
	public LocationDropDownValue getLocationId() {
		return new LocationDropDownValue();
	}

	@Override
	public String getPhoneNumber() {
		return "0000000000";
	}

	@Override
	public int getRequestID() {
		return 15;
	}

	@Override
	public String getRoomNumber() {
		return "215";
	}

	@Override
	public StatusDropDownValue getStatus() {
		return new StatusDropDownValue();
	}

	@Override
	boolean isValid() {
		return true;
	}

	@Override
	public void setComments(String comments) {
		super.setComments(comments);
	}

	@Override
	public void setDateEntered(Date dateEntered) {
		super.setDateEntered(dateEntered);
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		super.setEmailAddress(emailAddress);
	}

	@Override
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}

	@Override
	public void setIssueId(IssueDropDownValue issue) {
		super.setIssueId(issue);
	}

	@Override
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}

	@Override
	public void setLocationId(LocationDropDownValue location) {
		super.setLocationId(location);
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		super.setPhoneNumber(phoneNumber);
	}

	@Override
	protected void setRequestID(int requestID) {
		super.setRequestID(requestID);
	}

	@Override
	public void setRoomNumber(String roomNumber) {
		// TODO Auto-generated method stub
		super.setRoomNumber(roomNumber);
	}

	@Override
	public void setStatus(StatusDropDownValue status) {
		super.setStatus(status);
	}



}
