package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Login_Controller {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Perform login validation here (check username and password)

        if ("your_username".equals(username) && "your_password".equals(password)) {
            messageLabel.setText("Login successful!");
        } else {
            messageLabel.setText("Invalid username or password. Please try again.");
        }
    }
}
