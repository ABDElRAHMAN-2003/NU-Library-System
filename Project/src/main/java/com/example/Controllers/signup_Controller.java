package com.example.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import com.example.Models.MongoDBConnector;
import com.example.Models.Student;

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

    public void initialize() {
        // Filter for character input only
        UnaryOperator<TextFormatter.Change> characterFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[a-zA-Z]*") && newText.length() <= 16) {
                return change;
            }
            return null;
        };

        FirstName.setTextFormatter(new TextFormatter<>(characterFilter));
        LastName.setTextFormatter(new TextFormatter<>(characterFilter));

        // Filter for numeric input only
        UnaryOperator<TextFormatter.Change> numericFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-9]*") && newText.length() <= 11) {
                return change;
            }
            return null;
        };

        phoneField.setTextFormatter(new TextFormatter<>(numericFilter));
    }
    
    @FXML
    private void handleSignUp(ActionEvent event) throws IOException{

        String email = emailField.getText();
        String password = passwordField.getText();
        String Confirmpass= confirmPassword.getText();
        String firstName = FirstName.getText();
        String lastName = LastName.getText();
        String phone = phoneField.getText();

        // Perform validation and signup logic
        if (isValidEmail(email)){
                if (isValidInput(Confirmpass,password, firstName, lastName, phone)) {
                // Create a new Student object
                Student newStudent = new Student(email, password, firstName, lastName, phone);

                mongoConnector.insertStudent(newStudent);

                messageLabel.setText("Signup successful!");
                handleLogin(event);
            }
        }
        else {
            messageLabel.setText("Invalid input. Please check your information.");
        }
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/View/login.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root, 1280, 800);

        // Create a new stage for the signin window
        Stage LogInStage = new Stage();
        LogInStage.setScene(scene);
        LogInStage.show();

        // Close the current stage (signup window)
        Stage signUpStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        signUpStage.close();
    }
    
    // Perform input validation
    private boolean isValidInput(String confirmpass, String password, String firstName, String lastName, String phone) {
        return !password.isEmpty() && firstName.length() > 2 && lastName.length() > 2 && phone.length() == 11 && password.equals(confirmpass);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+\\d{4}@nu\\.edu\\.eg$";
        boolean isUnique = !mongoConnector.emailExists(email);
        return email.matches(emailRegex) && isUnique;
    }

}
