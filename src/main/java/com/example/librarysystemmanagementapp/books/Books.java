package com.example.librarysystemmanagementapp.books;

public class Books {
    private String title;
    private String author;
    private String returnDate;

    public Books() {
    }

    public Books(String title, String author, String returnDate)
    {
        this.title = title;
        this.author = author;
        this.returnDate = returnDate;
    }

    public String getTitle() {return title;}
    public void setTitle(String bookName)
    {
        this.title = title;
    }

    public String getAuthor() {return author;}
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getReturnDate()
    {
        return returnDate;
    }
    public void setReturnDate(String returnDate)
    {
        this.returnDate = returnDate;
    }

}


