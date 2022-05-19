module com.example.librarysystemmanagementapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.librarysystemmanagementapp to javafx.fxml;
    exports com.example.librarysystemmanagementapp;
}