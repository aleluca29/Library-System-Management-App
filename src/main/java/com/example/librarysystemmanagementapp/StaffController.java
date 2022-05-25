package com.example.librarysystemmanagementapp;


import com.example.librarysystemmanagementapp.books.BooksList;
import com.example.librarysystemmanagementapp.books.Book;
import com.example.librarysystemmanagementapp.orders.Orders;
import com.example.librarysystemmanagementapp.orders.OrdersList;
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

    @FXML
    private Button finalizeRequest;

    @FXML
    private TableView<Orders> tableOfOrdersStaff;

    @FXML
    private TableColumn<Orders, String> authorColumnStaffOrder;

    @FXML
    private TableColumn<Orders, String> returnDateColumnStaffOrder;

    @FXML
    private TableColumn<Orders, String> titleColumnStaffOrder;

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
        try {
            OrdersList.loadOrdersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        ObservableList<Book> observableList = FXCollections.observableArrayList(BooksList.getBooksArrayList());
        tableOfBooks.setItems(observableList);

        titleColumnStaffOrder.setCellValueFactory(new PropertyValueFactory<Orders, String>("title"));
        authorColumnStaffOrder.setCellValueFactory(new PropertyValueFactory<Orders, String>("author"));
        returnDateColumnStaffOrder.setCellValueFactory(new PropertyValueFactory<Orders, String>("returnDate"));

        ObservableList<Orders> observableList1 = FXCollections.observableArrayList(OrdersList.getOrdersArrayList());
        tableOfOrdersStaff.setItems(observableList1);

    }
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

    @FXML
    void removeFromOrder(ActionEvent event) throws IOException {
        int selectedID = tableOfOrdersStaff.getSelectionModel().getSelectedIndex();
        tableOfOrdersStaff.getItems().remove(selectedID);
        OrdersList.removeOrder(selectedID);
        OrdersList.saveBooksToOrder();
    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("initial.fxml");
    }

}
