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

    public String displayWelcomeMessage() {
        return "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!";
    }
    
    public String displayOptions() {
        return BibliotecaApp.showListAsString(new ArrayList<>(options.keySet()));
    }

    public String displayBooks() {
        return BibliotecaApp.showListAsString(books);
    }

    public void setUp() {
        setUpOptions();
        setUpBooks();
    }

    public void executeLibraryApplication(String input) {
        splitInput(input);
        try {
            options.get(command).execute(this);
        } catch (NullPointerException e) {
            displayRetry();
        }
    }

    private void splitInput(String input) {
        command = extractCommand(input);
        argument = extractArgument(input);
    }

    private String extractCommand(String input) {
        return input.split(" ")[0];
    }

    private String extractArgument(String input) {
        String[] temp = input.split(" ", 2);
        return temp.length > 1 ? temp[1] : "";
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
