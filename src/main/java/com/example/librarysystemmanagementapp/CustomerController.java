package com.example.librarysystemmanagementapp;
import com.example.librarysystemmanagementapp.books.Book;
import com.example.librarysystemmanagementapp.books.BooksList;
import com.example.librarysystemmanagementapp.orders.Orders;
import com.example.librarysystemmanagementapp.orders.OrdersList;
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

    private ObservableList<Orders> orders;

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
    private TableView<Orders> tableOfOrders;

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

        ObservableList<Orders> observableList1 = FXCollections.observableArrayList(OrdersList.getOrdersArrayList());
        tableOfOrders.setItems(observableList1);

    }


    @FXML
    void sendOrder(ActionEvent event) throws IOException {
        Orders book = new Orders(titleCustomer.getText(), (authorCusmoter.getText()), (returnDateCustomer.getText()));
        ObservableList<Orders> orders = tableOfOrders.getItems();
        orders.add(book);
        OrdersList.addOrder(book);
        tableOfOrders.setItems(orders);
        OrdersList.saveBooksToOrder();

    }


    @FXML
    void LogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("initial.fxml");
    }


}
