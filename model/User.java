package com.example.lenovo.letseat.model;

public class User {
    public static User usingperson; private  String Name;
    private String Password;

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    private String Phone;


    public User()
    {

    }
    public User(String name,String password,String phone)
    {
        Phone=phone;
        Name=name;
        Password=password;
    }
    public String getName()
    {
        return Name;
    }
    public  void setName(String name)
    {
        Name=name;
    }
    public String getPassword()
    {
        return Password;
    }
    public  void setPassword(String password)
    {
        Password=password;
    }
}