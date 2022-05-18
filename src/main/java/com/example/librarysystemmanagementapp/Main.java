package com.example.librarysystemmanagementapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primarystage) throws IOException {
        stg = primarystage;
        primarystage.setResizable(false);
        Parent root=FXMLLoader.load(getClass().getResource("initial.fxml"));
        primarystage.setTitle("Library System Management");
        primarystage.setScene(new Scene(root,900,650));
        primarystage.show();
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane= FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}