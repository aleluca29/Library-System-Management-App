package com.example.librarysystemmanagementapp;

import javafx.fxml.FXML;
import com.example.librarysystemmanagementapp.Main;
import com.example.librarysystemmanagementapp.user.UsersList;
import com.example.librarysystemmanagementapp.user.Users;
import com.example.librarysystemmanagementapp.servicies.Register;
import com.example.librarysystemmanagementapp.exceptions.UsernameAlreadyExistsException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterScene implements Initializable {

    public RegisterScene() {

    }

    @FXML
    private ChoiceBox<String> role;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label wrongCreate;

    private String[] options = {"Customer", "Library Staff"};

    public void userRegister(ActionEvent event) throws IOException {
        checkRegister();
    }

    private void checkRegister() throws IOException {
        if (username.getText().isEmpty()) {
            wrongCreate.setText("Please fill in the username field");
        } else if (password.getText().isEmpty()) {
            wrongCreate.setText("Please fill in the password field");
        } else if (role.getValue() == null) {
            wrongCreate.setText("Please fill in the options field");
        } else {
            try {
                Register.addUser(username.getText(), password.getText(), (String) role.getValue());
                wrongCreate.setText("Account created successfully");
            } catch (UsernameAlreadyExistsException e) {
                wrongCreate.setText(e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.getItems().addAll(options);
    }

    public void moveToFirstPage() throws IOException {
        Main m = new Main();
        m.changeScene("initial.fxml");
    }
}