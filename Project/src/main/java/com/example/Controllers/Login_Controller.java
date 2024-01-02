package com.example.Controllers;

import java.io.IOException;

import com.example.Models.Student;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

import io.github.cdimascio.dotenv.Dotenv;

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

    public Student active_Student;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public void initialize(){
        mongoClient = MongoClients.create(Dotenv.load().get("MONGODB"));
        database = mongoClient.getDatabase("NULibrary");
        collection = database.getCollection("Users");
    }

    @FXML
    private void mainPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/View/mainpage.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1280, 800);

        Stage mainPageStage = new Stage(); // Create a new stage for the mainPage window
        mainPageStage.setScene(scene);
        mainPageStage.setTitle("Main Page");
        mainPageStage.show();

        // Close the login stage
        Stage loginStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        loginStage.close();
    }

    @FXML
    private void adminpage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/View/mainpageAdmin.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1280, 800);

        Stage adminmainPageStage = new Stage(); // Create a new stage for the adminPage window
        adminmainPageStage.setScene(scene);
        adminmainPageStage.setTitle(" Main Page ");
        adminmainPageStage.show();

        // Close the login stage
        Stage loginStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        loginStage.close();
    }
    
    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();
    
        // Perform login validation here (check email and password)
        Document query = new Document("email", email).append("password", password);
        Document adminDocument = collection.find(query).first();

        if (adminDocument != null && isValidEmail(email)) {
            // Login successful
            active_Student = documentToStudent(adminDocument);
            UserManager.getInstance().setActiveStudent(active_Student);
            mainPage(event);
        }

        else if(adminDocument != null && isValidAdmin(email)){
            // redirect to admin page 
            UserManager.getInstance().setActiveStudent(null);
            adminpage(event);
        }

        else {
            messageLabel.setText("Invalid email or password. Please try again.");
        }
    }
    

    @FXML
    private void handleSignUpScene (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/View/signup.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1280, 800);

        Stage signUpStage = new Stage(); // Create a new stage for the signup window
        signUpStage.setScene(scene);
        signUpStage.setTitle("Sign Up Page");
        signUpStage.show();

        // Close the login stage
        Stage loginStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        loginStage.close();
    }
    
    // @FXML
    // private void handleFP(ActionEvent event)throws IOException {


    // }

    private boolean isValidAdmin(String email) {
        String emailRegex = "^[\\w-\\.]+@admin$";
        return email.matches(emailRegex);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+\\d{4}@nu\\.edu\\.eg$";
        return email.matches(emailRegex);
    }

    private Student documentToStudent(Document document) {
        String email = document.getString("email");
        String password = document.getString("password");
        String firstName = document.getString("firstName");
        String lastName = document.getString("lastName");
        String phoneNumber = document.getString("phoneNumber");

        return new Student(email, password, firstName, lastName, phoneNumber);
    }
}
