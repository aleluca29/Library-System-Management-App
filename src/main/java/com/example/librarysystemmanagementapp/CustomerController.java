package com.example.librarysystemmanagementapp;
import com.example.librarysystemmanagementapp.books.Book;
import com.example.librarysystemmanagementapp.books.BooksList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    public CustomerController() {
    }

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> dateColumn;

    @FXML
    private TableView<Book> tableOfBooks;

    @FXML
    private TableColumn<Book, String> titleColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("returnDate"));
        try {
            BooksList.loadBooksFromFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        ObservableList<Book> observableList = FXCollections.observableArrayList(BooksList.getBooks());
        tableOfBooks.setItems(observableList);
    }

}
