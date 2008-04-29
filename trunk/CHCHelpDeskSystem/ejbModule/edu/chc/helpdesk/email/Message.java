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

//TODO 15-04-08 Should be able to construct it's content based on what type of message it is (Corresponding with the MessageType Enum)  Especially the Subject line.  Because of this, we don't need a public setSubject() method because the subject will be built at run time.

/**
 * @author tim
 * 
 */
public class Message {

	String body; //TODO delete
	String from; 
	String host; 
	Properties props;
	String subject; //TODO delete
	String to; //TODO delete
	
	//FIXME Change to HelpRequest Parameter.
	public Message(String to, String subject, String body) {
		this.props = new Properties();
		this.host = "mailhost.chc.edu";
		this.from = "helpdesk@chc.edu";
		this.props.put("mail.smtp.host", this.host);
		this.props.put("mail.from", this.from);
		this.to = to; //FIXME Change to an HelpRequest getter method access.  Next two as well.
		this.subject = subject;
		this.body = body;
	}

	//TODO Parameterize with a MessageType
	public String getBody() {
		//TODO Implement Customer and Tech options
		return this.body;
	}

	public String getFrom() {
		return this.from;
	}

	public String getHost() {
		return this.host;
	}

	public String getSubject() {
		return this.subject;
	}

	public String getTo() {
		return this.to;
	}

	//FIXME Call Message get methods to get things, rather than accessing fields directly
	public void send() throws MessageNotValidException {

		if (isValid()) {
			Session session = Session.getInstance(this.props, null);
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom();
				msg.setRecipients(RecipientType.TO, this.to);
				msg.setSubject(this.subject);
				msg.setSentDate(new Date());
				msg.setText(this.body);
				Transport.send(msg);
			} catch (MessagingException mex) {
				// TODO Properly catch this exception.
			}
		}

		throw new MessageNotValidException();

	}

	//TODO Decide whether or not we need this.
	public void setBody(String body) {
		this.body = body;
	}

	//TODO Decide whether or not we need this.
	private void setSubject() {
		//FIXME Create subject dynamically based on what type the message is.
		this.subject = subject;
	}

	//TODO Decide whether or not we need this.
	public void setTo(String to) {
		this.to = to;
	}

	//FIXME Change to check on HelpRequest information.
	private boolean isValid() {
		return !(this.props == null && this.host == null && this.from == null
		        && this.to == null && this.subject == null && this.body == null);
	}

}
