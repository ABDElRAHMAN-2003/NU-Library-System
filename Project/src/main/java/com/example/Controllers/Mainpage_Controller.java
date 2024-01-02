package com.example.Controllers;

import com.example.Controllers.UserManager;
import com.example.Models.Student;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Mainpage_Controller{
    Student active_Student =UserManager.getInstance().getActiveStudent();

    @FXML
    private Button ProfileButton;

    private Button lastPressedButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        // Simulate a click on the "Profile" button to set the initial content
        loadContent("/com/example/View/Profile.fxml");
        updateButtonStyles(ProfileButton);
    }
    
    // Event handler for the "Profile" button
    @FXML
        private void handleProfileButton(ActionEvent event) {
            // Clear the existing content of the GridPane
            Button clickedButton = (Button) event.getSource();
            updateButtonStyles(clickedButton);
            loadContent("/com/example/View/Profile.fxml");
            // Add new content to the GridPane for the "Profile" button action
            // Example:
            
            // Label label = new Label("Profile content");
            // System.out.println(active_Student);
            // gridPane.add(label, 0, 0);
        }


    // Event handler for the "Book" button
    @FXML
    private void handleBookButton(ActionEvent event) {
        // Clear the existing content of the GridPane
        Button clickedButton = (Button) event.getSource();
        updateButtonStyles(clickedButton);
        loadContent("/com/example/View/Book.fxml");
        
        // Add new content to the GridPane for the "Search" button action
        // You can create and add new nodes here to change the content
        // Example:
        // Label label = new Label("Search content");
        // gridPane.add(label, 0, 0);
    }

    // Event handler for the "Calendar" button
    @FXML
    private void handleCalendarButton(ActionEvent event) {
        // Clear the existing content of the GridPane
        Button clickedButton = (Button) event.getSource();
        updateButtonStyles(clickedButton);
        loadContent("/com/example/View/Calendar.fxml");
        // Add new content to the GridPane for the "Calendar" button action
        // Example:
        // Label label = new Label("Calendar content");
        // gridPane.add(label, 0, 0);
    }

    private void updateButtonStyles(Button clickedButton) {
        // Remove the CSS class from the last pressed button
        if (lastPressedButton != null) {
            lastPressedButton.getStyleClass().remove("btn-pressed");
        }

        // Add the CSS class to the clicked button
        clickedButton.getStyleClass().add("btn-pressed");

        // Update the lastPressedButton to the currently clicked button
        lastPressedButton = clickedButton;
    }

    private void loadContent(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node content = loader.load();
            gridPane.getChildren().clear();
            gridPane.add(content, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML 
    private void handleLogoutButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/View/login.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root, 1280, 800);

        // Create a new stage for the signin window
        Stage LogInStage = new Stage();
        LogInStage.setScene(scene);
        LogInStage.show();

        // Close the current stage (signup window)
        Stage MainPageStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        MainPageStage.close();
    }
}