package com.twu.biblioteca;

import java.util.ArrayList;

public class Session {

    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public Session() {
    }

    public void setUpOptions() {
        options.add(new Option(0, "exit"));
        options.add(new Option(1, "list of books"));
    }

    public void setUpBooks() {
        books.add(new Book("book1", "author1", "2001"));
        books.add(new Book("book2", "author2", "2002"));
        books.add(new Book("book3", "author3", "2003"));
    }

    public String displayWelcomeMessage() {
        return "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!";
    }
    
    public String displayOptions() {
        return BibliotecaApp.showListAsString(options);
    }

    public String displayBooks() {
        return BibliotecaApp.showListAsString(books);
    }

    public void setUp() {
        setUpOptions();
        setUpBooks();
    }
}
