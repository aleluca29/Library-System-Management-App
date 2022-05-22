package com.example.librarysystemmanagementapp.books;

import com.example.librarysystemmanagementapp.Main;
import com.example.librarysystemmanagementapp.user.Users;
import com.example.librarysystemmanagementapp.exceptions.UsernameAlreadyExistsException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class BooksList {

    private static ArrayList<Books> book = new ArrayList<>();

    public static void addBooks(Books newBook){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        book.add(newBook);
    }
/*
    private static void checkBookDoesNotAlreadyExist(String username) throws BookAlreadyExistsException {
        for (Books user : users) {
            if (Objects.equals(username, book.getUsername()))
                throw new BookAlreadyExistsException(username);
        }
    }

    public static boolean checkUserCredentials(Books book1) {
        return book.contains(book1);
    }
*/

    @Override
    public String toString() {
        return book.toString();
    }

    public static void loadBooksFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            book = objectMapper.readValue(Paths.get("books.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Books> getBooks() {
        return book;
    }

}
