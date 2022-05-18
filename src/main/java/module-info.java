module com.example.librarysystemmanagementapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.librarysystemmanagementapp to javafx.fxml;
    exports com.example.librarysystemmanagementapp;
}