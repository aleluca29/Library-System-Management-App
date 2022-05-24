package com.example.librarysystemmanagementapp.books;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BooksList {

    private static ArrayList<Book> booksArrayList = new ArrayList<>();

    public static void addBook(Book newBook){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        booksArrayList.add(newBook);
    }

    public static void removeBook(int bookId){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        booksArrayList.remove(bookId);
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
        return booksArrayList.toString();
    }

    public static void loadBooksFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            booksArrayList = objectMapper.readValue(Paths.get("books.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static void saveBooksToFile() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("books.json"), booksArrayList);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public static ArrayList<Book> getBooks() {
        return booksArrayList;
    }

}
