package com.example.librarysystemmanagementapp.books;

public class Book {
    private String title;
    private String author;
    private String returnDate;

    public Book() {
    }

    public Book(String title, String author, String returnDate)
    {
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

   // public String getNameUser() {return nameUser;}
    //public void setNameUser(String title)
    //{
       // this.nameUser = nameUser;
   // }

    //public ChoiceBox<String> getTitleOrder() {return titleOrder;}
    //public void setTitleOrder(String titleOrder)
   // {
       // this.titleOrder = titleOrder;
    //}

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}


