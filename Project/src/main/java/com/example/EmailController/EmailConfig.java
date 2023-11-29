package com.example.EmailController;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailConfig {
    private final Properties properties;

    public EmailConfig(String configFilePath) throws IOException {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFilePath)) {
            properties.load(input);
        }
    }

    public String getSmtpHost() {
        return properties.getProperty("mail.smtp.host");
    }

    public int getSmtpPort() {
        return Integer.parseInt(properties.getProperty("mail.smtp.port"));
    }

    public boolean isSmtpAuth() {
        return Boolean.parseBoolean(properties.getProperty("mail.smtp.auth"));
    }

    public boolean isStarttlsEnabled() {
        return Boolean.parseBoolean(properties.getProperty("mail.smtp.starttls.enable"));
    }

    public String getUsername() {
        return properties.getProperty("mail.username");
    }

    public String getPassword() {
        return properties.getProperty("mail.password");
    }
}