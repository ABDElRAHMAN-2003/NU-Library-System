package com.example;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.fxml.FXML;

public class BookVBoxController {
    
    @FXML
    private ImageView bookImage;
    
    @FXML
    private VBox scrollVBox;
    
    @FXML
    private Label bookTitle, remainingBooksLabel;

    @FXML
    private Button descriptionButton, borrowButton;
    
    public void setBookImage(String imageUrl) {
        Image image = new Image(imageUrl);
        bookImage.setImage(image);
    }
    
    public void setBookTitle(String title) {
        bookTitle.setText(title);
    }
    
    public void setRemainingBooks(int remainingBooks) {
        remainingBooksLabel.setText(String.valueOf(remainingBooks));
    }
}
