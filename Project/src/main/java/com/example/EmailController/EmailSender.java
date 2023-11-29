package com.example.EmailController;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class EmailSender {
    private final EmailConfig emailConfig;

    public EmailSender(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", emailConfig.getSmtpHost());
        properties.put("mail.smtp.port", emailConfig.getSmtpPort());
        properties.put("mail.smtp.auth", emailConfig.isSmtpAuth());
        properties.put("mail.smtp.starttls.enable", emailConfig.isStarttlsEnabled());

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfig.getUsername(), emailConfig.getPassword());
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailConfig.getUsername()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }
}