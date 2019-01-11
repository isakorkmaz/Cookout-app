package com.techelevator.model.attendee;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public void SendEmails (String email, String firstName, String lastName, String hostName) {
		
		final String username = "cookinwithflames@gmail.com";		// Required Gmail account's username/email-address
		final String password = "FrankG1nzo";				// and password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));   // From-address (i.e. the username/email-address)
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));		// cycle through a list of emails					
			message.setSubject("Cookin' With Fire Cookout Invite");
			message.setText("Hello " + firstName + " " + lastName + ", \n\n" +
					hostName + " has invited you to a cookout!! \n\n"
							+ "Check out the Cookin' With Fire application made by Team Bang to RSVP. \n\n"
							+ "Cookin' With Fire: where no cookouts have blazed before! \n\n"
							+ "Cookin' With Fire is a registered trademark with The United States Patent and Trademark Office.");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
