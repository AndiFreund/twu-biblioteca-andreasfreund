package com.twu.biblioteca;

import java.security.AuthProvider;
import java.util.List;
public class UserSession {

    private String command;
    private String argument;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
    private User user;

    public UserSession() {
    }

    public void setUp() {
        bookLibrary = new BookLibrary();
        movieLibrary = new MovieLibrary();
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

    public String getCommand() {
        return command;
    }

    public String getArgument() {
        return argument;
    }

    public BookLibrary getBookLibrary() {
        return bookLibrary;
    }

    public MediaLibrary getMovieLibrary() {
        return movieLibrary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
