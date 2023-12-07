package com.example;

import java.io.IOException;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

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
    
        MongoClient mongoClient;
        MongoDatabase database;
        MongoCollection<Document> collection;
    
        mongoClient = MongoClients.create("mongodb+srv://Maqdi:h8HVOmAJeVTEMmKd@nulibrarysystem.9c6hrww.mongodb.net/?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("NULibrary");
        collection = database.getCollection("Users");
    
        // Perform login validation here (check email and password)
        Document query = new Document("email", email).append("password", password);
        Document adminDocument = collection.find(query).first();
    
        if (adminDocument != null) {
            // Login successful
            mainPage(event);
            System.out.println("DONE");
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
