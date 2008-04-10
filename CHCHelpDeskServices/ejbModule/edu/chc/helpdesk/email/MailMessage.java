/**
 * 
 */
package edu.chc.helpdesk.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.Message.RecipientType;
import javax.mail.Message;

/**
 * @author tim
 * 
 */
public class MailMessage implements edu.chc.helpdesk.email.Message {

   public void send() {

      Properties props = new Properties();
      props.put("mail.smtp.host", "my-mail-server");
      props.put("mail.from", "helpdesk@chc.edu");
      Session session = Session.getInstance(props, null);

      try {
         MimeMessage msg = new MimeMessage(session);
         msg.setFrom();
         msg.setRecipients(RecipientType.TO, "tim.visher@gmail.com");
         msg.setSubject("JavaMail hello world example");
         msg.setSentDate(new Date());
         msg.setText("Hello, world!\n");
         Transport.send(msg);
      } catch (MessagingException mex) {
         System.out.println("send failed, exception: " + mex);
      }

   }

}
