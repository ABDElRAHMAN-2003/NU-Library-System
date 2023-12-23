package com.example.Models;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDBConnector {
    private static final String DATABASE_NAME = "NULibrary";
    private static final String Student_collection = "Users";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDBConnector() {
        // Connect to MongoDB
        mongoClient = MongoClients.create("mongodb+srv://Maqdi:h8HVOmAJeVTEMmKd@nulibrarysystem.9c6hrww.mongodb.net/?retryWrites=true&w=majority");
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

    
    public Student findStudentBystudentname(String email) {
        collection = database.getCollection(Student_collection);
        // Find the Student document by email
        Document StudentDocument = collection.find(Filters.eq("email", email)).first();
    
        // if (StudentDocument != null) {
        //     return new Student(
        //             StudentDocument.getString("studentname"),
        //             StudentDocument.getString("password"),
        //             StudentDocument.getString("firstName"),
        //             StudentDocument.getString("lastName"),
        //             StudentDocument.getString("phoneNumber"),
        //             StudentDocument.getString("email")
        //     );
        // }
    
        return null; // Student not found
    }
    

    // Add methods for update and delete as needed

    public void closeConnection() {
        // Close the MongoDB connection
        mongoClient.close();
    }
}
