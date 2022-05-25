package com.example.librarysystemmanagementapp.orders;

public class Orders {
    private String title;
    private String author;
    private String returnDate;
    public Orders() {
    }

    public Orders(String title, String author, String returnDate) {
        this.title = title;
        this.author = author;
        this.returnDate = returnDate;
    }
    public String getTitle() {return title;}
    public void setTitle(String title)
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

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }

}
