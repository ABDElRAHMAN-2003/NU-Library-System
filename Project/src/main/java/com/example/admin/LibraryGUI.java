package com.example.admin;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LibraryGUI extends Application {

    private Stage primaryStage;
    private int capacity;
    private int capacityValue;
    private ArrayList<Book> books;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Library System");
        Image icon = new Image("/icon.png");
        primaryStage.getIcons().add(icon);


        // ---------------------------------------------------------------------------------------------- //
        // Capacity Window //

        Background background = new Background(new BackgroundImage(new Image("/bg.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

        Label capacityLabel = new Label("Enter the capacity of the library:   ");
        TextField capacityField = new TextField();
        Button nextButton = new Button("Next");


        capacityLabel.setFont(Font.font("Century Gothic"));
        capacityLabel.setTextFill(Color.WHITE);

        nextButton.setPrefSize(200,20);
        nextButton.setStyle("-fx-background-color: transparent; -fx-border-color: #DEDEDE; -fx-border-width: 0.5px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");


        VBox capacityLayout = new VBox(10);

        capacityLayout.setPadding(new Insets(100));
        capacityLayout.getChildren().addAll(capacityLabel, capacityField, nextButton);
        capacityLayout.setAlignment(Pos.CENTER_RIGHT);
        capacityLayout.setBackground(background);

        capacityField.setAlignment(Pos.CENTER_RIGHT);
        capacityField.setMaxWidth(200);

        Scene capacityScene = new Scene(capacityLayout, 632, 352);
        
        primaryStage.setScene(capacityScene);
        primaryStage.setResizable(false);
        primaryStage.show();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);

        // ---------------------------------------------------------------------------------------------- //
        // Main Menu Window :

        Background buttonsBackground = new Background(new BackgroundImage(new Image("/ButtonsBg.png"),
                                                                            BackgroundRepeat.NO_REPEAT,
                                                                            BackgroundRepeat.NO_REPEAT, 
                                                                            BackgroundPosition.CENTER, 
                                                                            BackgroundSize.DEFAULT));


        Button addButton = new Button("Add a book");
        Button removeButton = new Button("Remove a book");
        Button borrowButton = new Button("Borrow a book");
        Button returnButton = new Button("Return a book");
        Button viewButton = new Button("View the library status");
        Button exitButton = new Button("Exit");

        addButton.setPrefSize(200,20);
        removeButton.setPrefSize(200,20);
        borrowButton.setPrefSize(200,20);
        returnButton.setPrefSize(200,20);
        viewButton.setPrefSize(200,20);
        exitButton.setPrefSize(200,20);

        addButton.setStyle("-fx-background-color: transparent; -fx-border-color: #DEDEDE; -fx-border-width: 0.5px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");
        removeButton.setStyle("-fx-background-color: transparent; -fx-border-color: #DEDEDE; -fx-border-width: 0.5px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");
        borrowButton.setStyle("-fx-background-color: transparent; -fx-border-color: #DEDEDE; -fx-border-width: 0.5px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");
        returnButton.setStyle("-fx-background-color: transparent; -fx-border-color: #DEDEDE; -fx-border-width: 0.5px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");
        viewButton.setStyle("-fx-background-color: transparent; -fx-border-color: #DEDEDE; -fx-border-width: 0.5px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");
        exitButton.setStyle("-fx-background-color: transparent; -fx-border-color: #FF0000; -fx-border-width: 0.5px; -fx-border-radius: 5px; -fx-text-fill: #FF0000; -fx-font-family: 'Century Gothic'; -fx-font-weight: bold;");

        
        VBox menuLayout = new VBox(10);
        menuLayout.setPadding(new Insets(110));
        menuLayout.getChildren().addAll(addButton, removeButton, borrowButton, returnButton, viewButton, exitButton);
        menuLayout.setAlignment(Pos.CENTER_RIGHT);
        menuLayout.setBackground(buttonsBackground);


        Scene menuScene = new Scene(menuLayout, 632, 352);



        // ---------------------------------------------------------------------------------------------- //
        // Add Book Window //

        Label categoryLabel = new Label("Select Category:                               ");
        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("Biology", "Maths", "History", "Chemistry", "Politics");
        categoryBox.setValue("Category");
        Label booknameLabel = new Label("Book Name:                                       ");
        TextField booknameField = new TextField();

        Button addBookButton = new Button("Add Book");
        Button backToMenuButton = new Button("Go Back");

        addBookButton.setPrefSize(200,20);
        addBookButton.setStyle("-fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: #00ff00; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #00ff00; -fx-font-family: 'Century Gothic'; ");

        backToMenuButton.setPrefSize(200,20);
        backToMenuButton.setStyle("-fx-background-color: transparent; -fx-border-color: #575757; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");


        booknameLabel.setFont(Font.font("Century Gothic"));
        booknameLabel.setTextFill(Color.WHITE);
        booknameField.setAlignment(Pos.CENTER_RIGHT);
        booknameField.setMaxWidth(200);


        categoryLabel.setFont(Font.font("Century Gothic"));
        categoryLabel.setTextFill(Color.WHITE);
        categoryBox.setPrefSize(200,20);

        capacityField.setAlignment(Pos.CENTER_RIGHT);
        capacityField.setMaxWidth(200);



        VBox categoryLayout = new VBox(10);
        categoryLayout.setPadding(new Insets(100));
        categoryLayout.getChildren().addAll(categoryLabel,categoryBox,booknameLabel,booknameField,addBookButton,backToMenuButton);
        categoryLayout.setAlignment(Pos.CENTER_RIGHT);
        categoryLayout.setBackground(buttonsBackground);
        VBox.setMargin(booknameLabel, new Insets(10, 0, 0, 0));

        Scene categoryScene = new Scene(categoryLayout, 632, 352);


        // ---------------------------------------------------------------------------------------------- //
        // Remove Book //


        Label deleteByID_Label = new Label("Enter Book ID:                                    ");
        TextField deleteByID_Field = new TextField();

        Button deleteBook_Button = new Button("Delete Book");
        Button backByDelete_Button = new Button("Go Back");

        deleteBook_Button.setPrefSize(200,20);
        deleteBook_Button.setStyle("-fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: #FF0000; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #FF0000; -fx-font-family: 'Century Gothic';");

        backByDelete_Button.setPrefSize(200,20);
        backByDelete_Button.setStyle("-fx-background-color: transparent; -fx-border-color: #575757; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");


        deleteByID_Label.setFont(Font.font("Century Gothic"));
        deleteByID_Label.setTextFill(Color.WHITE);
        deleteByID_Field.setAlignment(Pos.CENTER_RIGHT);
        deleteByID_Field.setMaxWidth(200);


        deleteByID_Field.setAlignment(Pos.CENTER_RIGHT);
        deleteByID_Field.setMaxWidth(200);



        VBox deleteLayout = new VBox(10);
        deleteLayout.setPadding(new Insets(100));
        deleteLayout.getChildren().addAll(deleteByID_Label,deleteByID_Field,deleteBook_Button,backByDelete_Button);
        deleteLayout.setAlignment(Pos.CENTER_RIGHT);
        deleteLayout.setBackground(buttonsBackground);
        VBox.setMargin(deleteByID_Label, new Insets(10, 0, 0, 0));

        Scene deleteScene = new Scene(deleteLayout, 632, 352);


        // ---------------------------------------------------------------------------------------------- //
        // Borrow Book //

        Label borrowByID_Label = new Label("Enter Book ID:                                    ");
        TextField borrowByID_Field = new TextField();

        Label borrowDate_Label = new Label("Enter Borrowing Period (in days):    ");
        TextField borrowDate_Field = new TextField();

        Button borrowBook_Button = new Button("Borrow Book");
        Button backByBorrow_Button = new Button("Go Back");

        borrowBook_Button.setPrefSize(200,20);
        borrowBook_Button.setStyle("-fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: #6495ED; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #6495ED; -fx-font-family: 'Century Gothic';");

        backByBorrow_Button.setPrefSize(200,20);
        backByBorrow_Button.setStyle("-fx-background-color: transparent; -fx-border-color: #575757; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");


        borrowByID_Label.setFont(Font.font("Century Gothic"));
        borrowByID_Label.setTextFill(Color.WHITE);
        borrowByID_Field.setAlignment(Pos.CENTER_RIGHT);
        borrowByID_Field.setMaxWidth(200);

        borrowDate_Label.setFont(Font.font("Century Gothic"));
        borrowDate_Label.setTextFill(Color.WHITE);
        borrowDate_Field.setAlignment(Pos.CENTER_RIGHT);
        borrowDate_Field.setMaxWidth(200);


        borrowByID_Field.setAlignment(Pos.CENTER_RIGHT);
        borrowByID_Field.setMaxWidth(200);



        VBox borrowLayout = new VBox(10);
        borrowLayout.setPadding(new Insets(100));
        borrowLayout.getChildren().addAll(borrowByID_Label,borrowByID_Field,borrowDate_Label,borrowDate_Field,borrowBook_Button,backByBorrow_Button);
        borrowLayout.setAlignment(Pos.CENTER_RIGHT);
        borrowLayout.setBackground(buttonsBackground);
        VBox.setMargin(borrowByID_Label, new Insets(10, 0, 0, 0));

        Scene borrowScene = new Scene(borrowLayout, 632, 352);

        // ---------------------------------------------------------------------------------------------- //
        // return Book //

        Label returnByID_Label = new Label("Enter Book ID:                                    ");
        TextField returnByID_Field = new TextField();

        Button returnBook_Button = new Button("Return Book");
        Button backByReturn_Button = new Button("Go Back");

        returnBook_Button.setPrefSize(200,20);
        returnBook_Button.setStyle("-fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: #e39e14; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #e39e14; -fx-font-family: 'Century Gothic';");


        backByReturn_Button.setStyle("-fx-background-color: transparent; -fx-border-color: #575757; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");
        backByReturn_Button.setPrefSize(200,20);

        returnByID_Label.setFont(Font.font("Century Gothic"));
        returnByID_Label.setTextFill(Color.WHITE);
        returnByID_Field.setAlignment(Pos.CENTER_RIGHT);
        returnByID_Field.setMaxWidth(200);


        returnByID_Field.setAlignment(Pos.CENTER_RIGHT);
        returnByID_Field.setMaxWidth(200);



        VBox returnLayout = new VBox(10);
        returnLayout.setPadding(new Insets(100));
        returnLayout.getChildren().addAll(returnByID_Label,returnByID_Field,returnBook_Button,backByReturn_Button);
        returnLayout.setAlignment(Pos.CENTER_RIGHT);
        returnLayout.setBackground(buttonsBackground);
        VBox.setMargin(returnByID_Label, new Insets(10, 0, 0, 0));

        Scene returnScene = new Scene(returnLayout, 632, 352);

        // ---------------------------------------------------------------------------------------------- //
        // View Library Status Window
        Background backgroundStatus = new Background(new BackgroundImage(new Image("/statusScene.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

        Label statusLabel = new Label("Library Status:");
        TextArea statusTextArea = new TextArea();
        Button backToMenuByViewButton = new Button("Go Back");

        statusLabel.setFont(Font.font("Century Gothic"));
        statusLabel.setTextFill(Color.WHITE);
        statusTextArea.setEditable(false);
        statusTextArea.setWrapText(true);
        statusTextArea.setPrefRowCount(70); 


        backToMenuByViewButton.setPrefSize(200, 20);
        backToMenuByViewButton.setStyle("-fx-background-color: transparent; -fx-border-color: #575757; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-text-fill: #f5f5f5; -fx-font-family: 'Century Gothic';");

        VBox statusLayout = new VBox(10);
        statusLayout.setPadding(new Insets(60));
        statusLayout.getChildren().addAll(statusLabel, statusTextArea, backToMenuByViewButton);
        statusLayout.setAlignment(Pos.CENTER);
        statusLayout.setBackground(backgroundStatus);


        Scene statusScene = new Scene(statusLayout, 632, 352);
        
        // ---------------------------------------------------------------------------------------------- //
        // Event handlers //
        nextButton.setOnAction(e -> {
            try {
                capacity = Integer.parseInt(capacityField.getText());
                capacityValue = capacity;
                books = new ArrayList<>();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("The capacity of the library is " + capacity);
                alert.showAndWait();
                primaryStage.setScene(menuScene);
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a valid number.");
                alert.showAndWait();
            }
        });



        // Event handlers //
        // 6 Buttons: //

        addButton.setOnAction(e -> {
            if(checkLibraryCapacity(capacityValue) == true){
                primaryStage.setScene(categoryScene);
            }

            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("There is no space, please try again");
                alert.showAndWait();
                primaryStage.setScene(menuScene);
            }});

        removeButton.setOnAction(e -> {
            if (!books.isEmpty()) {
                primaryStage.setScene(deleteScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The library is empty, \n Try to add a book instead.");
                alert.showAndWait();
            }
        });
        
        borrowButton.setOnAction(e -> {
            if (!books.isEmpty()) {
                primaryStage.setScene(borrowScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The library is empty, \n Try to add a book instead.");
                alert.showAndWait();
            }
        });

        returnButton.setOnAction(e -> {
            if (!books.isEmpty()) {
                primaryStage.setScene(returnScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The library is empty, \n Try to add a book instead.");
                alert.showAndWait();
            }
        });

        viewButton.setOnAction(e -> {
            StringBuilder statusBuilder = new StringBuilder();
            statusBuilder.append("Library Status:\n");
            statusBuilder.append("------------------------------\n");
            for (Book book : books) {
                statusBuilder.append("Book ID: ").append(book.getId()).append("\n");
                statusBuilder.append("Book Name: ").append(book.getName()).append("\n");
                statusBuilder.append("Category: ").append(book.getCategory()).append("\n");
                if (book.isBorrowed()) {
                    statusBuilder.append("Status: Borrowed\n");
                    statusBuilder.append("Borrowing Date: ").append(book.getBorrowingDate()).append("\n");
                    statusBuilder.append("Borrowing Period: ").append(book.getBorrowingPeriod()).append(" days\n");
                } else {
                    statusBuilder.append("Status: Available\n");
                }
                statusBuilder.append("------------------------------\n");
            }
            int totalBooks = books.size();
            int borrowedBooks = countBorrowedBooks();
            statusBuilder.append("Total Number of Books: ").append(totalBooks).append("\n");
            statusBuilder.append("Total Number of Borrowed Books: ").append(borrowedBooks).append("\n");
    
            statusBuilder.append("------------------------------\n");
            statusBuilder.append("Books by Category:\n");
            ArrayList<String> categories = getUniqueCategories();
            for (String category : categories) {
                int count = countBooksByCategory(category);
                statusBuilder.append(category).append(": ").append(count).append("\n");
            }
    
            statusTextArea.setText(statusBuilder.toString());
            primaryStage.setScene(statusScene);
        });

        

        exitButton.setOnAction(e -> primaryStage.close());
        
        // ---------------------------------------------------------------------------------------------- //
        // INSIDE BUTTONS ACTIONS :
        addBookButton.setOnAction(e -> {
            int i = 1;
            String category = categoryBox.getValue();
            String bookName = booknameField.getText();
            if (categoryBox.getValue() != "Category" && !category.isEmpty() && bookName != null && !bookName.isEmpty()) {

                if(i <= capacity) {
                    Book newBook = new Book(bookName, category);
                    books.add(newBook);
                    i++;

                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("- Category: " + newBook.getCategory()
                                        + "\n- Book ID : " + newBook.getId()
                                        + "\n- Book Name: " + newBook.getName());
                    alert.showAndWait();
                    primaryStage.setScene(menuScene);
                    capacityValue--;
                    categoryBox.setValue("Category");
                    booknameField.clear();

                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please select a category and enter a book name.");
                alert.showAndWait();
            }
        });

        backToMenuButton.setOnAction(e -> { 
                    primaryStage.setScene(menuScene);
                    categoryBox.setValue("Category");
                    booknameField.clear();
                });
        
        deleteBook_Button.setOnAction(e -> {
            try{
                int bookId = Integer.parseInt(deleteByID_Field.getText());

                Book bookToBorrow = null;
                for (Book book : books) {
                    if (book.getId() == bookId) {
                        bookToBorrow = book;
                        break;
                    }
                }
                
                if (bookToBorrow != null) {
                    // Check if the book is borrowed
                    if (bookToBorrow.isBorrowed()) {
                        // Book is borrowed, show an error message
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Cannot delete a borrowed book.");
                        alert.showAndWait();
                        deleteByID_Field.clear();
                    } else {
                        books.remove(bookToBorrow);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("# Book Details :" 
                                                + "\n  - Book Name: " + bookToBorrow.getName()
                                                + "\n  - Book ID: " + bookToBorrow.getId()
                                                + "\n  - Book Catagory: " + bookToBorrow.getCategory()
                                                + "\n\n# Book Deleted Successfully !");
                        alert.showAndWait();
                        capacityValue++;
                        deleteByID_Field.clear();
                        primaryStage.setScene(menuScene);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Book with ID " + bookId + " does not exist.");
                    alert.showAndWait();
                    deleteByID_Field.clear();
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid input for book ID. \nPlease enter a valid integer number.");
                alert.showAndWait();
                deleteByID_Field.clear();
            }
        });

        backByDelete_Button.setOnAction(e -> { 
            primaryStage.setScene(menuScene);
            deleteByID_Field.clear();
        });

        borrowBook_Button.setOnAction(e -> {
            try{
                int bookId = Integer.parseInt(borrowByID_Field.getText());
                int borrowingPeriod = Integer.parseInt(borrowDate_Field.getText());

                Book bookToBorrow = null;
                for (Book book : books) {
                    if (book.getId() == bookId) {
                        bookToBorrow = book;
                        break;
                    }
                }
                
                if (bookToBorrow != null) {
                    LocalDate returnDate = LocalDate.now().plusDays(borrowingPeriod);
                    // Check if the book is borrowed
                    if (bookToBorrow.isBorrowed()) {
                        // Book is borrowed, show an error message
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("book is borrowed. Return Date: " + returnDate);
                        alert.showAndWait();
                        borrowByID_Field.clear();
                        borrowDate_Field.clear();
                    } else {
                        
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("# Book Details :" 
                                                + "\n  - Book Name: " + bookToBorrow.getName()
                                                + "\n  - Book ID: " + bookToBorrow.getId()
                                                + "\n  - Book Catagory: " + bookToBorrow.getCategory()
                                                + "\n\n# Book Borrowed Successfully! "
                                                + "\n# Return Date: " + returnDate);

                        bookToBorrow.borrowBook(returnDate);
                        alert.showAndWait();
                        borrowByID_Field.clear();
                        borrowDate_Field.clear();
                        primaryStage.setScene(menuScene);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Book with ID " + bookId + " does not exist.");
                    alert.showAndWait();
                    borrowByID_Field.clear();
                    borrowDate_Field.clear();
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid input for book ID or the borrowing period. \nPlease enter a valid integer number.");
                alert.showAndWait();
                borrowByID_Field.clear();
                borrowDate_Field.clear();
            }
        });

        backByBorrow_Button.setOnAction(e -> { 
            primaryStage.setScene(menuScene);
            borrowByID_Field.clear();
            borrowDate_Field.clear();
        });
        
        returnBook_Button.setOnAction(e -> {
            try{
                int bookID= Integer.parseInt(returnByID_Field.getText());
                Book booktoreturn = null;
                for ( Book book : books)
                {
                    if (book.getId() == bookID)
                    {
                        booktoreturn = book;
                        break;
                    }
                }

                if (booktoreturn !=null)
                {
                    if (booktoreturn.isBorrowed())
                    {   
                        booktoreturn.returnBook();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("# Book Details :"
                                + "\n  - Book Name: " + booktoreturn.getName()
                                + "\n  - Book ID: " + booktoreturn.getId()
                                + "\n  - Book Catagory: " + booktoreturn.getCategory()
                                + "\n\n# Book returned Successfully !");
                        alert.showAndWait();
                        returnByID_Field.clear();
                        primaryStage.setScene(menuScene);
                    }
                    else {
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Book is not borrowed");
                        alert.showAndWait();
                        returnByID_Field.clear();
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Book with ID " + bookID + " does not exist.");
                    alert.showAndWait();
                    returnByID_Field.clear();
                }}
            catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid input for book ID. \nPlease enter a valid integer number.");
                alert.showAndWait();
                returnByID_Field.clear();
            }});
        
        backByReturn_Button.setOnAction(e -> { 
                primaryStage.setScene(menuScene);
                returnByID_Field.clear();
            });

        backToMenuByViewButton.setOnAction(e -> primaryStage.setScene(menuScene));}



    //Functions :

    public boolean checkLibraryCapacity(int capacityInt) {
    if (capacityInt != 0){return true;}
    else {return false;}
    }

    // Helper method to count the number of books in a specific category
    private int countBooksByCategory(String category) {
        int count = 0;
        for (Book book : books) {
            if (book.getCategory().equals(category)) {
                count++;
            }
        }
        return count;
    }

    private int countBorrowedBooks() {
        int count = 0;
        for (Book book : books) {
            if (book.isBorrowed()) {
                count++;
            }
        }
        return count;
    }
            
    private ArrayList<String> getUniqueCategories() {
        ArrayList<String> categories = new ArrayList<>();
        for (Book book : books) {
            String category = book.getCategory();
            if (!categories.contains(category)) {
                categories.add(category);
            }
        }
        return categories;
    }



        
    public static void main(String[] args) {
        launch(args);
    }

}
