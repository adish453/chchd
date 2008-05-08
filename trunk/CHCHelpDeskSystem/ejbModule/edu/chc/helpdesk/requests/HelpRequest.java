package edu.chc.helpdesk.requests;

import javax.persistence.*;
import java.util.Date;
import static javax.persistence.TemporalType.DATE;

/** 
 * 
 * @author Michael Spross
 * @version 0.1
 * @desc An entity bean that represents a row in the HelpRequest table.
 */

@Entity
@NamedQuery(name="getAllRequests", query="SELECT r FROM HelpRequest r")
@Table(schema="HelpDeskDB")
public class HelpRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int requestID;
	
	@Temporal(DATE)
	private Date dateEntered;

	@Column(name="STATUS_ID")
	private int statusId;
	@Column(name="ISSUE_ID")
	private int issueId;
	@Column(name="LOCATION_ID")
	private int locationId;
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String roomNumber;
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
	 * @return the date this request was entered
	 */	
	public Date getDateEntered() {
		return dateEntered;
	}
	/**
	 * @param dateEntered the date this request was added
	 */
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
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
	
	boolean isValid()
	{
		//TODO Implement
		return true;
	}
	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the issueId
	 */
	public int getIssueId() {
		return issueId;
	}
	/**
	 * @param issueId the issueId to set
	 */
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}	
}
