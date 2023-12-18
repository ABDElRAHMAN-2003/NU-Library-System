package com.example;

import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BookController {

    @FXML
    private TextField searchField;

    @FXML
    private GridPane innerGridPane;

    public void initialize() throws FileNotFoundException, IOException, CsvValidationException, NumberFormatException {
        
    //Adds book to database Via CSV file
    
        // try (MongoClient mongoClient = MongoClients.create("mongodb+srv://Ali:suy4C1XDn5fHQOyd@nulibrarysystem.9c6hrww.mongodb.net/?retryWrites=true&w=majority")) {
        //     // Access the database
        //     MongoDatabase database = mongoClient.getDatabase("NULibrary");
        //     // Access the collection
        //     MongoCollection<Document> collection = database.getCollection("Books");
            
        //     // Reader for CSV data
        //     try (CSVReader csvReader = new CSVReaderBuilder(new FileReader("D:\\Book1.csv"))
        //             .withSkipLines(1) // Skip header row
        //             .build()) {
                
        //         String[] nextRecord;
        //         List<Document> bookDocuments = new ArrayList<>();
                
        //         // Read each row from the CSV file
        //         while ((nextRecord = csvReader.readNext()) != null) {
        //             // Assuming the CSV columns are Title, Author, Description, CoverImageUrl, RemainingBooks
        //             Document book = new Document()
        //                     .append("title", nextRecord[0])
        //                     .append("description", nextRecord[1])
        //                     .append("coverImageUrl", nextRecord[2])
        //                     .append("remainingBooks", Integer.parseInt(nextRecord[3]));
        //             bookDocuments.add(book);
        //         }
                
        //         // Insert the book documents into the MongoDB collection
        //         collection.insertMany(bookDocuments);
        //     }
        // }

        List<NewBook> books = getBooks();

        for (int i = 0; i < books.size(); i++) {
            try {
                NewBook book = books.get(i);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BookVBox.fxml"));

                // Load the book FXML and get the controller
                VBox bookVBox = loader.load();
                BookVBoxController controller = loader.getController();
                innerGridPane.getChildren();

                // Set the data in the controller
                controller.setBookImage(book.getCoverImageUrl());
                controller.setBookTitle(book.getTitle());
                controller.setRemainingBooks(book.getRemainingBooks());
                
                // Add the VBox to the inner GridPane with specified row and column indices
                // Assuming a 3-column grid layout here; calculate row and column from the index
                innerGridPane.add(bookVBox, i % 3, i / 3);
            } catch (Exception e) {
                e.printStackTrace();
            }         
        }
    }

    private List<NewBook> getBooks() {
        List<NewBook> books = new ArrayList<>();
        MongoClient mongoClient = null;
        
        try {
            // Connect to the MongoDB server (assumes MongoDB is running on localhost on default port 27017)
            mongoClient = MongoClients.create("mongodb+srv://Ali:suy4C1XDn5fHQOyd@nulibrarysystem.9c6hrww.mongodb.net/?retryWrites=true&w=majority");

            // Access the database
            MongoDatabase database = mongoClient.getDatabase("NULibrary");

            // Access the collection
            MongoCollection<Document> collection = database.getCollection("Books");

            // Fetch all documents in the collection (you may want to limit the number of documents)
            for (Document doc : collection.find()) {
                String title = doc.getString("title");
                String description = doc.getString("description");
                String coverImageUrl = doc.getString("coverImageUrl");
                int remainingBooks = doc.getInteger("remainingBooks", 0);
                String duedate = doc.getString("DueDate");
                
                System.out.println(title);
                // Create a new Book object and add it to the list
                books.add(new NewBook(title, description, coverImageUrl, remainingBooks,duedate));
            }
        } finally {
            // Close the client connection to free up resources
            if (mongoClient != null) {
                mongoClient.close();
            }
        }

        return books;
    }

    
}