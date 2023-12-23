module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    requires org.mongodb.driver.sync.client;
    requires transitive org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires com.opencsv;

    requires io.github.cdimascio.dotenv.java;

    requires org.slf4j;
    requires ch.qos.logback.classic;

    exports com.example.Controllers; 
    opens com.example.Controllers to javafx.fxml;

    exports com.example.Models;
    opens com.example.Models to javafx.fxml;

    requires java.mail;

    opens com.example to javafx.fxml;
    exports com.example;
}
