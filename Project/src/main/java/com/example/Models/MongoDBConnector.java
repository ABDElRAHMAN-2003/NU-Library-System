package com.example.Models;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.regex.Pattern;

import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDBConnector {
    private static final String DATABASE_NAME = "NULibrary";
    private static final String Student_collection = "Users";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDBConnector() {
        // Connect to MongoDB
        mongoClient = MongoClients.create(Dotenv.load().get("MONGODB"));
        database = mongoClient.getDatabase(DATABASE_NAME);
    }
    
    public void insertStudent(Student Student) {

        collection = database.getCollection(Student_collection);

        Document StudentDocument = new Document("email", Student.getEmail())
                .append("password", Student.getPassword())
                .append("firstName", Student.getFirstName())  
                .append("lastName", Student.getLastName())
                .append("phoneNumber", Student.getPhoneNumber());

        // Insert the document into the collection
        collection.insertOne(StudentDocument);
    }

    
    public Student findStudentByStudentEmail(String email) {
        collection = database.getCollection(Student_collection);

        // Create a case-insensitive regex query for the email
        Bson caseInsensitiveQuery = Filters.regex("email", "^" + Pattern.quote(email) + "$", "i");

        // Find the Student document by email
        Document studentDocument = collection.find(caseInsensitiveQuery).first();

        if (studentDocument != null) {
            return new Student(
                    studentDocument.getString("email"),
                    studentDocument.getString("password"),
                    studentDocument.getString("firstName"),
                    studentDocument.getString("lastName"),
                    studentDocument.getString("phoneNumber")
            );
        }
        return null; // Student not found
    }
    
    public boolean emailExists(String email) {
        collection = database.getCollection(Student_collection);

        // Use a case-insensitive regular expression for email
        Bson caseInsensitiveQuery = Filters.regex("email", "^" + Pattern.quote(email) + "$", "i");
        
        // Check if a document with the given email exists
        return collection.countDocuments(caseInsensitiveQuery) > 0;
    }
    // Add methods for update and delete as needed

    public void closeConnection() {
        // Close the MongoDB connection
        mongoClient.close();
    }
}
