module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    requires org.mongodb.driver.sync.client;
    requires transitive org.mongodb.bson;
    requires org.mongodb.driver.core;

    requires org.slf4j;
    requires ch.qos.logback.classic;

    requires java.mail;
    requires activation;

    opens com.example to javafx.fxml;
    exports com.example;
}
