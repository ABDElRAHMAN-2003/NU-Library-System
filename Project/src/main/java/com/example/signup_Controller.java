package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class signup_Controller {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField phoneField;

    @FXML
    private void handleSignUp(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();
        String phone = phoneField.getText();

        // Perform validation and signup logic

        // Update messageLabel if needed
        messageLabel.setText("Signup successful!");
    }
}