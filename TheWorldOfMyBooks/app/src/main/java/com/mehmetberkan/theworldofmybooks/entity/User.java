package com.mehmetberkan.theworldofmybooks.entity;

public class User {
    private int id;
    private String nameSurname;
    private String userName;
    private String password;

    public User(int id, String nameSurname, String userName, String password) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
