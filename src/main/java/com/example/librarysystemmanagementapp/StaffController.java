package com.example.librarysystemmanagementapp;


import com.example.librarysystemmanagementapp.books.BooksList;
import com.example.librarysystemmanagementapp.books.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    public StaffController() {
    }

    @FXML
    private TableView<Book> tableOfBooks;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> dateColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TextField dateText;

    @FXML
    private TextField authorText;

    @FXML
    private TextField titleText;

    @FXML
    private Button removeButton;

    @FXML
    private Button submitButton;
/*

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("returnDate"));
    }
*/
    //Submit button
    @FXML
    void submit(ActionEvent event) throws IOException {
        Book book = new Book(titleText.getText(), (authorText.getText()), (dateText.getText()));
        ObservableList<Book> books = tableOfBooks.getItems();
        books.add(book);
        BooksList.addBook(book);
        tableOfBooks.setItems(books);
        BooksList.saveBooksToFile();
    }

    @FXML
    void removeBook(ActionEvent event) throws IOException {
        int selectedID = tableOfBooks.getSelectionModel().getSelectedIndex();
        tableOfBooks.getItems().remove(selectedID);
        BooksList.removeBook(selectedID);
        BooksList.saveBooksToFile();
    }


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
