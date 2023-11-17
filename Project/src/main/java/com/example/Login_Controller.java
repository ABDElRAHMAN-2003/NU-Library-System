package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class Login_Controller {

    @FXML
    private TextField emailField;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField phoneField;

    @FXML
    private void mainPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1280, 800);

        Stage signUpStage = new Stage(); // Create a new stage for the signup window
        signUpStage.setScene(scene);
        signUpStage.setTitle(" Main Page ");
        signUpStage.show();

        // Close the login stage
        Stage loginStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        loginStage.close();
        // Handle signup logic here
    }
    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Perform login validation here (check email and password)

        if ("admin".equals(email) && "admin".equals(password)) {
            // messageLabel.setText("Login successful!");
            mainPage(event);

            
        } else {
            messageLabel.setText("Invalid email or password. Please try again.");
        }
    }

    @FXML
    private void handleSignUpScene (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1280, 800);

        Stage signUpStage = new Stage(); // Create a new stage for the signup window
        signUpStage.setScene(scene);
        signUpStage.setTitle("Sign Up Page");
        signUpStage.show();

        // Close the login stage
        Stage loginStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        loginStage.close();
        // Handle signup logic here
    }
    
    
}
