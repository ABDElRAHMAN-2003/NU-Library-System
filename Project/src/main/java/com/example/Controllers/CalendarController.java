package com.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class CalendarController implements Initializable {

    private ZonedDateTime dateFocus;
    private ZonedDateTime today;

    @FXML
    private Text year;

    @FXML
    private Text month;

    @FXML
    private FlowPane calendar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();
        drawCalendar();
    }

    @FXML
    void backOneMonth(ActionEvent event) {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void forwardOneMonth(ActionEvent event) {
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    private void drawCalendar() {
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        int monthMaxDate = dateFocus.getMonth().maxLength();
        // Check for leap year
        if (dateFocus.getYear() % 4 != 0 && monthMaxDate == 29) {
            monthMaxDate = 28;
        }
        int dateOffset = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1, 0, 0, 0, 0, dateFocus.getZone()).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();
                Rectangle rectangle = new Rectangle();

                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth = (calendarWidth / 7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight / 6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j + 1) + (7 * i);
                if (calculatedDate > dateOffset) {
                    int currentDate = calculatedDate - dateOffset;
                    if (currentDate <= monthMaxDate) {
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = - (rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);
                    }
                    if (today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate) {
                        rectangle.setStroke(Color.BLUE);
                    }
                }
                calendar.getChildren().add(stackPane);
                
            }
        }

        // MongoDB integration
        // try (MongoClient mongoClient = MongoClients.create("mongodb+srv://Maqdi:h8HVOmAJeVTEMmKd@nulibrarysystem.9c6hrww.mongodb.net/?retryWrites=true&w=majority")) {
        //     MongoDatabase database = mongoClient.getDatabase("NULibrary");
        //     MongoCollection<Document> collection = database.getCollection("Books");

        //     // Fetch books from MongoDB
        //     MongoCursor<Document> cursor = collection.find().iterator();
        //     try {
        //         while (cursor.hasNext()) {
        //             Document bookDocument = cursor.next();
        //             String bookDueDate = bookDocument.getString("dueDate");

        //             if (bookDueDate != null && !bookDueDate.isEmpty()) {
        //                 // Parse the due date string to a ZonedDateTime or another suitable date representation
        //                 try {
        //                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.ENGLISH);
        //                     ZonedDateTime dueDateTime = ZonedDateTime.parse(bookDueDate, formatter);
                        
        //                     // Check if the book's due date corresponds to the current calendar date
        //                     if (dueDateTime.getYear() == dateFocus.getYear() && dueDateTime.getMonth() == dateFocus.getMonth()) {
        //                         int dueDay = dueDateTime.getDayOfMonth();
        //                         String bookName = bookDocument.getString("title"); // Retrieve book name
        //                         Text dueDateText = new Text("Due: " + dueDay + "\nBook: " + bookName);
        //                         double textTranslationY = - (calendarHeight / 2) * 0.75;
        //                         dueDateText.setTranslateY(textTranslationY + 20);
        //                         StackPane stackPane = new StackPane();
        //                         stackPane.getChildren().addAll(new Rectangle(), dueDateText);
        //                         calendar.getChildren().add(stackPane);
        //                     }
        //                 } catch (DateTimeParseException e) {
        //                     // Handle the case where parsing fails (e.g., due to invalid date format)
        //                     System.err.println("Error parsing due date: " + bookDueDate);
        //                 }
        //             }
        //         }
        //     } finally {
        //         cursor.close();
        //     }
        // }
    }
}
