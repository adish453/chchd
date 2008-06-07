/**
 * 
 */
package edu.chc.helpdesk.email;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;

//import com.sun.enterprise.admin.util.Logger;

import edu.chc.helpdesk.requests.HelpRequest;

//TODO 15-04-08 Should be able to construct it's content based on what type of message it is (Corresponding with the MessageType Enum)  Especially the Subject line.  Because of this, we don't need a public setSubject() method because the subject will be built at run time.

/**
 * @author tim
 * 
 * Message is used to send e-mails.  It generates them 
 * dynamically by using data out of the HelpRequest object passed to it 
 * in its constructor.
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

	/**
	 * Dynamically generates the body of a HelpRequest confirmation e-mail.
	 * @param type The type of message this body is for.
	 * @return The body of this message.
	 * @throws MessageNotValidException If the type passed in is an unsupported type.
	 */
	String getBody(MessageType type) throws MessageNotValidException {	
		StringBuilder body = new StringBuilder();
		String sep = System.getProperty("line.separator");
		switch (type) {
			case TECH:
				
				String formattedDate;
				SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM d, yyyy");
				formattedDate = df.format(request.getDateEntered());
				
				//Submission Date
				body.append("Date Submitted: ");
				body.append(formattedDate);
				body.append(sep);
				//Customer Name
				body.append("Submitted by: ");
				body.append(request.getLastName());
				body.append(", ");
				body.append(request.getFirstName());
				body.append(sep);
				//Location
				body.append("Location: ");
				body.append(request.getLocation().getDisplayValue());
				body.append(", Room ");
				body.append(request.getRoomNumber());
				body.append(sep);
				//Telephone Number
				body.append("Phone: ");
				body.append(request.getPhoneNumberFormatted());
				body.append(sep);
				//E-Mail
				body.append("E-Mail: ");
				body.append(request.getEmailAddress());
				body.append(sep);
				//Issue
				body.append("Issue: ");
				body.append(request.getIssue().getDisplayValue());
				body.append(sep).append(sep);
				//Comment
				body.append("Additional Comments: ");
				body.append(sep).append(sep);
				body.append(request.getComments());
				return body.toString();
			case CUSTOMER:
				body.append("Thank you for contacting CHC Helpdesk.  Your request has been " +
						    "received and will be processed shortly.  So we can more easily assist " +
						    "you, please remember your case number and give it to the tech helping " +
						    "you with this problem.");
				body.append(sep + sep);
				body.append("Thank you and have a nice day.");
				body.append(sep + sep);
				body.append("Case Number: ");
				body.append(request.getRequestID());
				return body.toString();
			default:
				throw new MessageNotValidException();
		}
	}

	/**
	 * Returns the from address.
	 * @return The from address.
	 */
	String getFrom() {
		return this.from;
	}

	/**
	 * Returns the SMTP host being used by this message.
	 * @return The SMTP host.
	 */
	String getHost() {
		return this.host;
	}

	/**
	 * Dynamically generates the Subject line based on the type of message being 
	 * generated.
	 * @param type The type of message being sent.
	 * @return The subject line.
	 * @throws MessageNotValidException If the type is an unsupported type.
	 */
	String getSubject(MessageType type) throws MessageNotValidException {
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

	/**
	 * Dynamically generates the To Recipient based on the the type of 
	 * Message being generated.
	 * @param type The Message Type.
	 * @return The To Field.
	 * @throws MessageNotValidException If the type of Message is unsupported.
	 */
	String getTo(MessageType type) throws MessageNotValidException {
		switch (type) {
			case TECH:
				return "helpdesk@chc.edu";
			case CUSTOMER:
				return request.getEmailAddress();
		}
		throw new MessageNotValidException();
	}

	/**
	 * Takes care of dynamically generating the e-mail and sending it out 
	 * using the SMTP host.  Validates the message content.
	 * @param type The type of message to send.
	 * @throws MessageNotValidException If the message is not valid 
	 */
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
				//FIXME Utilize java.util.logging instead?  This implementation ties us directly to the app server...
				//Logger.log(getBody(type));
				Transport.send(msg);
				
			} catch (MessagingException mex) {
				// TODO Properly catch this exception.
			}
		}
		else {
			throw new MessageNotValidException();
		}

	}

	//TODO Make this more robust
	/**
	 * Validates the Message generated for a given type.
	 */
	boolean isValid(MessageType type) {
		try {
	        return !(this.props == null && this.host == null && this.from == null
	                && getTo(type) == null && getSubject(type) == null && getBody(type) == null);
        } catch (MessageNotValidException e) {
	        return false;
        }
	}

}
