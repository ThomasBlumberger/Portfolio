package com.example.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSystem {
	private Properties props;
	private Session session;
	
	public EmailSystem() {
		this.props = new Properties();
		this.props.put("mail.smtp.auth", "true");
		this.props.put("mail.smtp.starttls.enable", "true");
		this.props.put("mail.smtp.host", "smtp-mail.outlook.com");
		this.props.put("mail.smtp.port", "587");

		this.session = Session.getInstance(this.props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("scrumgroup6uol@outlook.com", "hdkfnciwoxps123");
			}
		});
	}
		
	public void sendEmail(String destinationEmailAddress, String subject, String message) throws AddressException, MessagingException, IOException {
		MimeMessage mMessage = new MimeMessage(this.session);
		mMessage.setFrom(new InternetAddress("scrumgroup6uol@outlook.com", false));
		mMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationEmailAddress));
		mMessage.setSentDate(new Date());
		mMessage.setSubject(subject);
		mMessage.setContent(message, "text/html");
		Transport.send(mMessage);
	}
}
