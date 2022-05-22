package com.example.librarysystemmanagementapp.books;

public class Books {
    private String author;
    private String bookName;
    private String returnDate;

    public Books() {
    }

    public String getAuthor() {return author;}
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getBookName() {return bookName;}
    public void setBookName(String bookName)
    {
        this.bookName = bookName;
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


