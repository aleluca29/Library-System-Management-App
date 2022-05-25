package com.example.librarysystemmanagementapp.orders;

import com.example.librarysystemmanagementapp.orders.Orders;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OrdersList {

    private static ArrayList<Orders> ordersArrayList = new ArrayList<>();

    public static void addOrder(Orders newOrder){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        ordersArrayList.add(newOrder);
    }

    public static void removeOrder(int bookId){
        //checkBookDoesNotAlreadyExist(newBook.getUsername());  //throws BookAlreadyExistsException
        ordersArrayList.remove(bookId);
    }
    @Override
    public String toString() {
        return ordersArrayList.toString();
    }


    public static void saveBooksToOrder() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("booksOrder.json"), ordersArrayList);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public static String getOrders() {
        return String.valueOf(ordersArrayList);
    }
    public static ArrayList<Orders> getBooksArrayList() {
        return ordersArrayList;
    }
}
