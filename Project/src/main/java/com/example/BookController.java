package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BookController {

    @FXML
    private TextField searchField;

    @FXML
    private VBox scrollVBox;

    @FXML
    private GridPane innerGridPane;

    public void initialize() {
        // Sample data, replace this with your actual data
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                // Create a new VBox for each iteration
                VBox vbox = createBookVBox(i, j);

                // Add the VBox to the inner GridPane with specified row and column indices
                innerGridPane.add(vbox, j, i);
            }
        }
    }

    private VBox createBookVBox(int row, int col) {
        // Create your VBox with the desired content
        VBox vbox = new VBox();
        // Add content to the VBox
        vbox.getStyleClass().add("books");
        // Example: Adding a Label with row and col information
        vbox.getChildren().add(new javafx.scene.control.Label("Row: " + row + ", Col: " + col));

        // You can customize the VBox contents based on your requirements

        return vbox;
    }
}
