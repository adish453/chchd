package edu.chc.helpdesk.requests;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
	
	@ManyToOne
	@JoinColumn(name="STATUS_ID", insertable=false, updatable=false)
	private StatusDropDownValue status;
	@ManyToOne
	@JoinColumn(name="ISSUE_ID", insertable=false, updatable=false)
	private IssueDropDownValue issue;
	@ManyToOne
	@JoinColumn(name="LOCATION_ID", insertable=false, updatable=false)
	private LocationDropDownValue location;
	
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
	
	//no-arg constructor
	public HelpRequest() {}
	
	boolean isValid()
	{
		// Check phone number length
		if(this.phoneNumber.length() > 10) {
			return false;
		}

		//TODO Add additional validation here if needed...
		
		return true;
	}
	
	/**
	 * @return the requestID
	 */
	public int getRequestID() {
		return requestID;
	}
	/**
	 * @param requestID the requestID to set.
	 * Protected because only JPA should modify this field.
	 */
	protected void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	/**
	 * @return the dateEntered
	 */
	public Date getDateEntered() {
		return dateEntered;
	}
	/**
	 * @param dateEntered the dateEntered to set
	 */
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
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
	/**
	 * @return the issue
	 */
	public IssueDropDownValue getIssue() {
		return issue;
	}
	/**
	 * @param issue the issue to set
	 */
	public void setIssue(IssueDropDownValue issue) {
		this.issue = issue;
	}
	/**
	 * @return the location
	 */
	public LocationDropDownValue getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(LocationDropDownValue location) {
		this.location = location;
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
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		//strip formatting characters from phone number
		phoneNumber = phoneNumber.replaceAll("\\D", "");
		this.phoneNumber = phoneNumber;
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
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
}
