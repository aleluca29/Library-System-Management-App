package com.example.librarysystemmanagementapp;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.librarysystemmanagementapp.books.Books;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    public StaffController() {
    }

    @FXML
    private TableColumn<Books, String> authorColumn;

    @FXML
    private TableColumn<Books, String> dateColumn;

    @FXML
    private TableView<Books> tableOfBooks;

    @FXML
    private TableColumn<Books,String> titleColumn;


   // public static void main(String[] args) {


        final ObjectMapper objectMapper = new ObjectMapper();
        List<Books> booksList = null;

        {
            try {
                booksList = objectMapper.readValue(new File("books.json"), new TypeReference<>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //booksList.forEach(x -> System.out.println(x.toString()));
   // }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        titleColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Books,String>("returnDate"));

        tableOfBooks.setItems((ObservableList<Books>) booksList);
    }
}

