package com.twu.biblioteca;

public class User {

    String id;
    String password;
    String name;
    String email;
    String phonenumber;

    public User(String id, String password, String name, String email, String phonenumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public boolean validPassword(String password) {
        return this.password.equals(password);
    }
}
