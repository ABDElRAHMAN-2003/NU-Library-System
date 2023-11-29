
package com.example.EmailController;

import javax.mail.MessagingException;

import java.io.IOException;



public class App {

    public static void main(String[] args) {
        // Load email configuration from the properties file
        EmailConfig emailConfig;
        try {
            emailConfig = new EmailConfig("config.properties");
        } catch (IOException e) {
            System.err.println("Error loading email configuration: " + e.getMessage());
            return;
        }

        // Instantiate the EmailSender using the loaded configuration
        EmailSender emailSender = new EmailSender(emailConfig);

        // Example usage: Send an email
        try {
            String to = "A.Magdi2190@nu.edu.eg";
            String subject = "Test Email";
            String body = "This is a test email sent from my Java application.";
            emailSender.sendEmail(to, subject, body);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}