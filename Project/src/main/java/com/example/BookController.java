// package com.example 

// import javafx.fxml.FXML;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.VBox;

// public class BookController {

//     @FXML
//     private VBox mainVBox;

//     @FXML
//     private ScrollPane bookDisplayScrollPane;

//     @FXML
//     private VBox scrollVBox;

//     @FXML
//     private TextField searchField;

//     public void initialize() {
//         // Example data - Display VBox elements in ScrollPane
//         displayVBoxesInScrollPane();
//     }

//     private void displayVBoxesInScrollPane() {
//         int numberOfVBoxes = 10; // Set the number of VBox elements

//         for (int i = 0; i < numberOfVBoxes; i++) {
//             VBox vBox = createVBoxWithIndex(i);
//             scrollVBox.getChildren().add(vBox);
//         }
//     }

//     private VBox createVBoxWithIndex(int index) {
//         VBox vBox = new VBox();
//         vBox.getStyleClass().add("your-vbox-style"); 

//         Label labelIndex = new Label("Index: " + index);
//         Label labelText = new Label("VBox " + index);

//         vBox.getChildren().addAll(labelIndex, labelText);
//         return vBox;
//     }
// }
