package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Session {

    private Map<String, Option> options = new HashMap<>();
    private ArrayList<Book> books = new ArrayList<>();
    private String command;
    private String argument;

    public Session() {
    }

    public void setUp() {
        setUpOptions();
        setUpBooks();
    }

    private void setUpOptions() {
        options.put("quit", new Option("quit", "quit"));
        options.put("list", new Option("list", "list of books"));
        options.put("checkout", new Option("checkout", "check out a book, \"checkout title\""));
    }

    private void setUpBooks() {
        books.add(new Book("book1", "author1", "2001"));
        books.add(new Book("book2", "author2", "2002"));
        books.add(new Book("book3", "author3", "2003"));
    }

    public String displayAvailableBooks() {
        String result = "";
        for (Book book : books) {
            if (book.isInStock()) {
                result += book.toString() + "\n";
            }
        }
        return result;
    }

    public void executeLibraryApplication(String input) {
        command = BibliotecaApp.extractCommand(input);
        argument = BibliotecaApp.extractArgument(input);
        try {
            options.get(command).execute(this);
        } catch (NullPointerException e) {
            displayRetry();
        }
    }

    public String displayWelcomeMessage() {
        return "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!";
    }

    public String displayOptions() {
        return BibliotecaApp.showListAsString(new ArrayList<>(options.keySet()));
    }

    private void displayRetry() {
        System.out.println("Please select a valid options!");
        System.out.println(displayOptions());
    }

    public String getArgument() {
        return argument;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
