module com.example.task10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task10 to javafx.fxml;
    exports com.example.task10;
}