package com.example.librarysystemmanagementapp.user;

public class Users {
    public String username;
    public String password;
    public String status;

    public Users()
    {

    }

    public Users(String username, String password, String status)
    {
        this.username=username;
        this.password=password;
        this.status=status;
    }
    public String getUsername()
    {

        return username;
    }

    public void setUsername(String username)
    {

        this.username=username;
    }

    public String getPassword()
    {

        return password;
    }
    public void setPassword()
    {

        this.password=password;
    }
    public String getStatus()
    {

        return status;
    }
    public void setStatus()
    {

        this.status=status;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Users user=(Users) o;
        if(!username.equals(user.username))
            return false;
        if(!password.equals(user.password))
            return false;
        return status.equals(user.status);

    }
}
