module com.example.task10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task10 to javafx.fxml;
    exports com.example.task10;
    exports com.example.task10.controller;
    opens com.example.task10.controller to javafx.fxml;
    exports com.example.task10.model;
    opens com.example.task10.model to javafx.fxml;
}