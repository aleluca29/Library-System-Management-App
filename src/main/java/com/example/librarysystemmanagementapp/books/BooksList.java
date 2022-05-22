package com.example.librarysystemmanagementapp.books;



import com.example.librarysystemmanagementapp.user.Users;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BooksList {
    private static ArrayList<Books> books = new ArrayList<>();

    public static void addUser(Books newBook)  {
        books.add(newBook);
    }

    @Override
    public String toString() {
        return books.toString();
    }

    public static void loadUsersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            books = objectMapper.readValue(Paths.get("books.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Books> getBooks() {
        return books;
    }
}
