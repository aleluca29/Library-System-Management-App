package com.example.librarysystemmanagementapp.servicies;

import com.example.librarysystemmanagementapp.books.Book;
import com.example.librarysystemmanagementapp.books.BooksList;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.ChoiceBox;

import java.io.File;
import java.io.IOException;

public class OrderRegister {

    public static void addOrder(String title, String author, String returnDate)  {
        BooksList.addBook(new Book(title,author,returnDate));
        persistBooks();
    }

    private static void persistBooks() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("users.json"), BooksList.getBooks());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
