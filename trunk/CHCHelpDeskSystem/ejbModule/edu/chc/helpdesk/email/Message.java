/**
 * 
 */
package edu.chc.helpdesk.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;

import com.sun.enterprise.admin.util.Logger;

import edu.chc.helpdesk.requests.HelpRequest;

//TODO 15-04-08 Should be able to construct it's content based on what type of message it is (Corresponding with the MessageType Enum)  Especially the Subject line.  Because of this, we don't need a public setSubject() method because the subject will be built at run time.

/**
 * @author tim
 * 
 */
public class Message {
	
	private final String from = "helpdesk@chc.edu";
	private final String host = "mailhost.chc.edu";

	Properties props;
	HelpRequest request;
	
	public Message(HelpRequest request) {
		this.props = new Properties();
		this.props.put("mail.smtp.host", this.host);
		this.props.put("mail.from", this.from);
		
		//this.subject = subject;
		//this.body = body;
		this.request = request;
	}

	public String getBody(MessageType type) throws MessageNotValidException {	
		//TODO Implement Customer and Tech options
		StringBuilder body = new StringBuilder();
		String sep = System.getProperty("line.separator");
		switch (type) {
			case TECH:
				//Submission Date
				body.append("Date of Submission - ");
				body.append(request.getDateEntered());
				body.append(sep);
				//Customer Name
				body.append("Customer Name - ");
				body.append(request.getLastName());
				body.append(", ");
				body.append(request.getFirstName());
				body.append(sep);
				//Location
				body.append("Location - ");
				body.append(request.getLocation().getDisplayValue());
				body.append(sep);
				//Telephone Number
				body.append("Telephone Number - ");
				body.append(request.getPhoneNumber());
				body.append(sep);
				//Issue
				body.append("Issue - ");
				body.append(request.getIssue().getDisplayValue());
				body.append(sep);
				//Comment
				body.append("Comment - ");
				body.append(request.getComments());
				return body.toString();
			case CUSTOMER:
				body.append("Thank you for contacting CHC Helpdesk.  Your request has been recieved and will be processed shortly.  So we can more easily assist you, please remember your case number and give it to the tech helping you with this problem.");
				body.append(sep);
				body.append("Thank you and have a nice day.");
				body.append(sep);
				body.append("Case Number - ");
				body.append(request.getRequestID());
				return body.toString();
			default:
				throw new MessageNotValidException();
		}
	}

	public String getFrom() {
		return this.from;
	}

	public String getHost() {
		return this.host;
	}

	public String getSubject(MessageType type) throws MessageNotValidException {
		StringBuilder subject = new StringBuilder();
		switch (type) {
			case TECH:
				subject.append("Help Request for ");
				subject.append(request.getIssue().getDisplayValue());
				subject.append(" from ");
				subject.append(request.getFirstName());
				subject.append(" ");
				subject.append(request.getLastName());
				return subject.toString();
			case CUSTOMER:
				subject.append("Your Help Request (id ");
				subject.append(request.getRequestID());
				subject.append(") Has Been Received.");
				return subject.toString();
		}
		throw new MessageNotValidException();
	}

	public String getTo(MessageType type) throws MessageNotValidException {
		switch (type) {
			case TECH:
				return "helpdesk@chc.edu";
			case CUSTOMER:
				return request.getEmailAddress();
		}
		throw new MessageNotValidException();
	}

	public void send(MessageType type) throws MessageNotValidException {

		if (isValid(type)) {
			Session session = Session.getInstance(this.props, null);
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom();
				msg.setRecipients(RecipientType.TO, getTo(type));
				msg.setSubject(getSubject(type));
				msg.setSentDate(new Date());
				msg.setText(getBody(type));
				
				// since the chc mail server
				// doesn't work off-campus,
				// temporarily log the e-mails to the app server log
				// instead of trying to send them.
				Logger.log(getBody(type));
				//Transport.send(msg);
				
			} catch (MessagingException mex) {
				// TODO Properly catch this exception.
			}
		}
		else {
			throw new MessageNotValidException();
		}

	}

	private boolean isValid(MessageType type) {
		try {
	        return !(this.props == null && this.host == null && this.from == null
	                && getTo(type) == null && getSubject(type) == null && getBody(type) == null);
        } catch (MessageNotValidException e) {
	        return false;
        }
	}

}
