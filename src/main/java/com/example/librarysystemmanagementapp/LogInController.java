package com.example.librarysystemmanagementapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;

import java.io.IOException;

public class LogInController implements Initializable {

    public LogInController() {

    }

    @FXML
    private Button logIn;

    @FXML
    private Label wrongLogIn;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private ChoiceBox<String> logInChoiceBox;

    private String [] options={"Customer","Library Staff"};

    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        if (username.getText().toString().equals("Ale") && password.getText().toString().equals("1234")) {
            wrongLogIn.setText("Success!");

            m.changeScene("afterLogin.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data");
        } else {
            wrongLogIn.setText("Wrong username or password");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInChoiceBox.getItems().addAll(options);
    }

}
