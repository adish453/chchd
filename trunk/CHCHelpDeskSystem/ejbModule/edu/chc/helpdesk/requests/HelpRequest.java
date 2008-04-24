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
//TODO A subject line separate from the comments would probably be good to have.
//TODO Location should probably be it's own entity so that we can make locations configurable in the program.
//TODO Add "assigned to" property or better: just point to a Technician record.
//TODO Should we stop and finalize the DB design or create new entities as needed and build the DB around them?
//TODO Start addressing all of these To-do's...

//TODO Add Issue field (will be a drop-down in the program)
//TODO Remove Urgent field
//TODO Add Location (will be a drop-down) and RoomNumber fields

@Entity
@NamedQuery(name="getAllRequests", query="SELECT r FROM HelpRequest r")
@Table(schema="HelpDeskDB")
public class HelpRequest {
	
	/**
	 * 
	 * @author mspross
	 * @desc Encapsulates request status codes
	 */
	
	//TODO Do we want a configurable status or are hard-coded values OK?
	public enum RequestStatus {
		OPEN,
		CLOSED,
		HOLD
	}
	
	@Id
	@GeneratedValue
	private int requestID;
	@Temporal(DATE)
	private Date dateEntered;
	private RequestStatus status;
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
	 * @return the status
	 */
	public RequestStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(RequestStatus status) {
		this.status = status;
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
	
	boolean isValid()
	{
		//TODO Implement
		return true;
	}
	
	
}
