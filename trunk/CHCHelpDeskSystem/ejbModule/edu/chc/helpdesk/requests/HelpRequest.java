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

//TODO Fix problems with JavaDoc generation (embedded HTML causing a problem?)
//TODO Location should probably be it's own entity so that we can make locations configurable in the program.
//TODO Add "assigned to" property or better: just point to a Technician record.
//TODO Should we stop and finalize the DB design or create new entities as needed and build the DB around them?
//TODO Start addressing all of these To-do's...

//TODO Add Issue field (will be a drop-down in the program)
//TODO Add Location (will be a drop-down) and RoomNumber fields

@Entity
@NamedQuery(name="getAllRequests", query="SELECT r FROM HelpRequest r")
@Table(schema="HelpDeskDB")
public class HelpRequest {

	@Id
	@GeneratedValue
	private int requestID;
	
	@Temporal(DATE)
	private Date dateEntered;
	
	@ManyToOne
	private StatusDropDownValue status;
	@ManyToOne
	private IssueDropDownValue issue;
	@ManyToOne
	private LocationDropDownValue location;
	
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
	 * @return the issue
	 */
	public IssueDropDownValue getIssueId() {
		return issue;
	}
	/**
	 * @param issue the issue to set
	 */
	public void setIssueId(IssueDropDownValue issue) {
		this.issue = issue;
	}
	/**
	 * @return the location
	 */
	public LocationDropDownValue getLocationId() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocationId(LocationDropDownValue location) {
		this.location = location;
	}
	/**
	 * @return the status
	 */
	public StatusDropDownValue getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusDropDownValue status) {
		this.status = status;
	}	
}
