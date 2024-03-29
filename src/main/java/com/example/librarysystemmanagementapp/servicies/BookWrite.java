package com.example.librarysystemmanagementapp.servicies;

import com.example.librarysystemmanagementapp.books.Book;

import java.io.File;
import java.io.IOException;

import com.example.librarysystemmanagementapp.books.BooksList;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BookWrite {

    public static void addBooks(String title, String author, String returnDate) {
        //throws UsernameAlreadyExistsException
        BooksList.addBook(new Book(title, author, returnDate));
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