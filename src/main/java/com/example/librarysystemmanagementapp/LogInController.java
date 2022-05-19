package com.example.librarysystemmanagementapp;

import com.example.librarysystemmanagementapp.exceptions.UsernameAlreadyExistsException;
import com.example.librarysystemmanagementapp.user.Users;
import com.example.librarysystemmanagementapp.user.UsersList;
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

    @FXML
    private void checkLogin() throws IOException{
        if(username.getText().isEmpty() && password.getText().isEmpty() && logInChoiceBox.getValue()==null)
        {
            wrongLogIn.setText("Please enter all your data.");
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty() && logInChoiceBox.getValue()!=null)
        {
            wrongLogIn.setText("PLease enter your username and password.");
        }
        else
        if(username.getText().isEmpty())
        {
            wrongLogIn.setText("Please enter your username.");
        }
        else if(password.getText().isEmpty())
        {
            wrongLogIn.setText("Please enter your password.");
        }
        else if(logInChoiceBox.getValue()==null)
        {
            wrongLogIn.setText("Please select your status.");
        }
        else if(UsersList.checkUserCredentials(new Users(username.getText(),password.getText(),logInChoiceBox.getValue())))
        {
            Main m=new Main();
            if(logInChoiceBox.getValue().equals("Customer"))
                m.changeScene("afterLogIn");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInChoiceBox.getItems().addAll(options);
    }

}
