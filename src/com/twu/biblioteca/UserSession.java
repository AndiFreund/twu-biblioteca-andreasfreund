package com.twu.biblioteca;

import java.util.List;
public class UserSession {

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
        String command = extractCommand(input);
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

    private String extractCommand(String input) {
        return input.split(" ")[0];
    }

    private String extractArgument(String input) {
        String[] temp = input.split(" ", 2);
        return temp.length > 1 ? temp[1] : "";
    }

    String getArgument() {
        return argument;
    }

    BookLibrary getBookLibrary() {
        return bookLibrary;
    }

    MediaLibrary getMovieLibrary() {
        return movieLibrary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    boolean isLoggedIn() {
        return user != null;
    }
}
