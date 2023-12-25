package com.example.Controllers;

import com.example.Controllers.UserManager;
import com.example.Models.Student;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Profile_Controller {


    @FXML
    private Label userNameLabel;

    @FXML
    private Hyperlink emailHyperlink;

    @FXML
    private Hyperlink phoneNumberHyperlink;

    public void initialize() {
        Student active_Student =UserManager.getInstance().getActiveStudent();
        userNameLabel.setText(active_Student.getFirstName() + " " + active_Student.getLastName());
        emailHyperlink.setText(active_Student.getEmail());
        phoneNumberHyperlink.setText(active_Student.getPhoneNumber());
    }
}
