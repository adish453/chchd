package edu.chc.helpdesk.model;

import javax.persistence.*;

/** 
 * 
 * @author Michael Spross
 * @version 0.1
 * @desc An entity bean that represents a row in the HelpRequest table.
 */

//TODO Fix problems with JavaDoc generation (embedded HTML causing a problem?)

@Entity
@Table(schema="HelpDeskDB")
@NamedQuery(name="getAllRequests", query="SELECT r FROM HelpRequest r")
public class HelpRequest {
	@Id
	private int requestID;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private boolean urgent;
	private String comments;
	/**
	 * @return the auto-generated database ID for the request
	 */
	public int getRequestID() {
		return requestID;
	}
	/**
	 * @param requestID the database ID for this request. This field is set automatically when a HelpRequest entity is persisted to the database.
	 */
	protected void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	/**
	 * @return the first name of the user who submitted the request
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the first name of the user who submitted the request
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the last name of the user who submitted the request
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the last name of the user who submitted the request
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the e-mail address of the user who submitted the request
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the e-mail address of the user who submitted the request
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the phone number of the end-user who submitted the request
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param the phone number of the end-user who submitted the request
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return <b>True</b> if the request is marked <i>Urgent</i>; <b>False</b> otherwise.
	 */
	public boolean isUrgent() {
		return urgent;
	}
	/**
	 * @param mark or unmark the request as <i>Urgent</i>
	 */
	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	/**
	 * @return additional comments entered by the end-user
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments additional comments entered by the end-user
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
