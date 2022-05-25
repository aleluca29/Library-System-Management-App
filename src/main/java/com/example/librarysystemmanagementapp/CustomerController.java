package com.example.librarysystemmanagementapp;
import com.example.librarysystemmanagementapp.books.Book;
import com.example.librarysystemmanagementapp.books.BooksList;
import com.example.librarysystemmanagementapp.exceptions.UsernameAlreadyExistsException;
import com.example.librarysystemmanagementapp.servicies.OrderRegister;
import com.example.librarysystemmanagementapp.servicies.Register;
import com.example.librarysystemmanagementapp.user.Users;
import com.example.librarysystemmanagementapp.user.UsersList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    //@FXML
    //private TextField nameUser;

    @FXML
    private Button requestButton;

   //@FXML
    //private ChoiceBox<String> borrowBook;

    @FXML
    private TextField authorCusmoter;

    @FXML
    private TextField returnDateCustomer;

    @FXML
    private TextField titleCustomer;

    @FXML
    private TableView<Book> tableOfOrders;

    @FXML
    private TableColumn<Book, String> titleOrder;


    @FXML
    private TableColumn<Book, String> authorOrder;


    @FXML
    private TableColumn<Book, String> returnDateOrder;

   //private String[] options = {"title1", "title2"};

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
        ObservableList<Book> observableList = FXCollections.observableArrayList(BooksList.getBooksArrayList());
        tableOfBooks.setItems(observableList);

        titleOrder.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorOrder.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        returnDateOrder.setCellValueFactory(new PropertyValueFactory<Book, String>("returnDate"));
       // try {
           // BooksList.loadBooksFromFile();
       // } catch (IOException e) {
         //   e.printStackTrace();
           // throw new RuntimeException();
       // }
       // ObservableList<Book> observableList1 = FXCollections.observableArrayList(BooksList.getBooksArrayList());
        //tableOfOrders.setItems(observableList1);

        

        //borrowBook.getItems().addAll(options); ///BooksList.getBooks()
    }


    @FXML
    void sendOrder(ActionEvent event) throws IOException {
        Book book = new Book(titleCustomer.getText(), (authorCusmoter.getText()), (returnDateCustomer.getText()));
        ObservableList<Book> books = tableOfOrders.getItems();
        books.add(book);
        BooksList.addBook(book);
        tableOfOrders.setItems(books);
        BooksList.saveBooksToOrder();

    }
    /*public void userRegister(ActionEvent event) throws IOException {
        checkRegister();
    }
    private void checkRegister() throws IOException {

                //OrderRegister.addBook(title.getText(), borrowBook.getSelectionModel().getSelectedItem().toString());
        BooksList.checkUserCredentials(new Users(username.getText(),password.getText(),role.getValue()))
    }*/




}
