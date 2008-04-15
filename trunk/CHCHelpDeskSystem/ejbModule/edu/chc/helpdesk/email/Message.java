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

/**
 * @author tim
 * 
 */
public class Message {

	String body;
	String from;
	String host;
	Properties props;
	String subject;
	String to;

	public Message() {
		this.props = new Properties();
		this.host = "mailhost.chc.edu";
		this.from = "helpdesk@chc.edu";
		this.props.put("mail.smtp.host", this.host);
		this.props.put("mail.from", this.from);
		this.to = null;
		this.subject = null;
		this.body = null;
	}
	
	public Message(String to, String subject, String body) {
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public String getBody() {
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

	public void send() throws MessageIsNotValidException {

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

		throw new MessageIsNotValidException();

	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTo(String to) {
		this.to = to;
	}

	private boolean isValid() {
		return !(this.props == null && this.host == null && this.from == null
		        && this.to == null && this.subject == null && this.body == null);
	}

}
