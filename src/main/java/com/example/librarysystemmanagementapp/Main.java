package com.example.librarysystemmanagementapp;

import com.example.librarysystemmanagementapp.user.UsersList;
import com.example.librarysystemmanagementapp.servicies.Register;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws IOException {
        UsersList.loadUsersFromFile();
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("initial.fxml"));
        primaryStage.setTitle("Library System Management");
        primaryStage.setScene(new Scene(root,900,650));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException
    {
        Parent pane=FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
