module com.example.librarysystemmanagementapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.json;


    opens com.example.librarysystemmanagementapp to javafx.fxml;
    exports com.example.librarysystemmanagementapp;
    exports com.example.librarysystemmanagementapp.exceptions;
    exports com.example.librarysystemmanagementapp.servicies;
    exports com.example.librarysystemmanagementapp.user;
    exports com.example.librarysystemmanagementapp.books;
    exports com.example.librarysystemmanagementapp.orders;
}