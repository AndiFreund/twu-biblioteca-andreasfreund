package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
public class UserSession {

    private List<Book> books = new ArrayList<>();
    private String command;
    private String argument;

    public UserSession() {
    }

    public void setUp() {
        setUpBooks();
    }

    private void setUpBooks() {
        books.add(new Book("book1", "author1", "2001"));
        books.add(new Book("book2", "author2", "2002"));
        books.add(new Book("book3", "author3", "2003"));
    }

    public String displayAvailableBooks() {
        StringBuilder builder = new StringBuilder();
        for (Book book : books) {
            if (book.isInStock()) {
                builder.append(book.toString());
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    public void executeLibraryApplication(String input) {
        command = extractCommand(input);
        argument = extractArgument(input);
        Option option = new Option(command);
        option.execute(this);
    }

    public String displayWelcomeMessage() {
        return "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!";
    }

    public String displayOptions() {
        Option option = new Option();
        return showListAsString(option.getCommands());
    }

    private String showListAsString(List list) {
        StringBuilder builder = new StringBuilder();
        for (Object item : list) {
            builder.append(item.toString());
            builder.append("\n");
        }

        return builder.toString();
    }

    String extractCommand(String input) {
        return input.split(" ")[0];
    }

    String extractArgument(String input) {
        String[] temp = input.split(" ", 2);
        return temp.length > 1 ? temp[1] : "";
    }

    public String getArgument() {
        return argument;
    }

    public List<Book> getBooks() {
        return books;
    }
}
