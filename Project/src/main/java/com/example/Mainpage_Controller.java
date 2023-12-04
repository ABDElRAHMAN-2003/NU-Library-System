package com.example;

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

    @FXML
    private Button ProfileButton;

    private Button lastPressedButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        // Simulate a click on the "Profile" button to set the initial content
        loadContent("Book.fxml");
        updateButtonStyles(ProfileButton);
    }
    
    // Event handler for the "Profile" button
    @FXML
        private void handleProfileButton(ActionEvent event) {
            // Clear the existing content of the GridPane
            Button clickedButton = (Button) event.getSource();
            updateButtonStyles(clickedButton);
            loadContent("login.fxml");
            // Add new content to the GridPane for the "Profile" button action
            // Example:
            // Label label = new Label("Profile content");
            // gridPane.add(label, 0, 0);
        }


    // Event handler for the "Book" button
    @FXML
    private void handleBookButton(ActionEvent event) {
        // Clear the existing content of the GridPane
        Button clickedButton = (Button) event.getSource();
        updateButtonStyles(clickedButton);
        loadContent("Book.fxml");
        
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
        loadContent("Calendar.fxml");
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
    private void handleLogoutButton(){
        gridPane.getChildren().clear();
    }
}