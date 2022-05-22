package com.example.librarysystemmanagementapp.servicies;

import com.example.librarysystemmanagementapp.books.Books;
import com.example.librarysystemmanagementapp.exceptions.UsernameAlreadyExistsException;
import com.example.librarysystemmanagementapp.user.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.librarysystemmanagementapp.books.BooksList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONString;


public class BookWrite {

    public static void addBooks(String title, String author, String returnDate) {
        //throws UsernameAlreadyExistsException
        BooksList.addBooks(new Books(title, author, returnDate));
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