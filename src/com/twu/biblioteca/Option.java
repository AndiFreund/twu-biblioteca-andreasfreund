package com.twu.biblioteca;

import java.util.*;

public class Option {

    private String command;
    private String description;
    private LibraryExecutable application;
    private Map<String, LibraryExecutable> executables = new HashMap<>();

    Option() {
        initializeExecutables();
    }

    Option(String command) {
        initializeExecutables();

        this.command = command;
        this.application = getApplication(command);
    }

    private void initializeExecutables() {
        executables.put("quit", new ExitCommand());
        executables.put("login", new LoginCommand());
        executables.put("mycontact", new ContactDetailsCommand());
        executables.put("listbooks", new ListBooksCommand());
        executables.put("listmovies", new ListMoviesCommand());
        executables.put("checkoutbook", new CheckOutBookCommand());
        executables.put("checkoutmovie", new CheckOutMovieCommand());
        executables.put("return", new ReturnBookCommand());
    }

    private LibraryExecutable getApplication(String command) {
        if (executables.containsKey(command)) {
            return executables.get(command);
        } else {
            return new RetryCommand();
        }
    }

    @Override
    public String toString() {
        return command;
    }

    void execute(UserSession session) {
        application.execute(session);
    }

    public List<String> getCommands() {
        return new ArrayList<>(executables.keySet());
    }
}
