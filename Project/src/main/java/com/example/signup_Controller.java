package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class signup_Controller {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField LastName;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField phoneField;

    @FXML
    private Label messageLabel;

    private MongoDBConnector mongoConnector = new MongoDBConnector();

    @FXML
    private void handleSignUp(ActionEvent event) {

        String email = emailField.getText();
        String password = passwordField.getText();
        String Confirmpass= confirmPassword.getText();
        String firstName = FirstName.getText();
        String lastName = LastName.getText();
        String phone = phoneField.getText();

        // Perform validation and signup logic
        if (isValidInput(email, Confirmpass,password, firstName, lastName, phone)) {
            // Create a new Student object
            Student newStudent = new Student(email, password, firstName, lastName, phone);

            mongoConnector.insertStudent(newStudent);

            // You can now use the 'newStudent' object as needed (e.g., save to a database)
            // Update messageLabel
            messageLabel.setText("Signup successful!");

        } else {
            // Update messageLabel if input is invalid
            messageLabel.setText("Invalid input. Please check your information.");
        }
    }

    @FXML
    private void handleSignin(ActionEvent event) throws IOException {
        // Load the signin.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root, 1280, 800);

        // Create a new stage for the signin window
        Stage signInStage = new Stage();
        signInStage.setScene(scene);
        signInStage.show();

        // Close the current stage (signup window)
        Stage signUpStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        signUpStage.close();
    }
     // Perform input validation
     private boolean isValidInput(String email, String confirmpass, String password, String firstName, String lastName, String phone) {
        return isValidEmail(email) && !password.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !phone.isEmpty() && password.equals(confirmpass);
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "\\d{4}@nu.edu.eg";
        String lastCharacters = email.substring(email.length() - 14);
        return !email.isEmpty() && lastCharacters.matches(emailPattern) && email.length()>=14;
    }

}
