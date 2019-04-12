package com.twu.biblioteca;

import java.util.*;

public class Option {

    private String command;
    private String description;
    private LibraryExecutable application;
    private Map<String, LibraryExecutable> executables = new HashMap<>();

    Option() {
        executables.put("quit", new ExitCommand());
        executables.put("list", new ListBooksCommand());
        executables.put("checkout", new CheckOutBookCommand());
        executables.put("return", new ReturnBookCommand());
    }

    Option(String command) {
        this.command = command;

        executables.put("quit", new ExitCommand());
        executables.put("list", new ListBooksCommand());
        executables.put("checkout", new CheckOutBookCommand());
        executables.put("return", new ReturnBookCommand());

        this.application = getApplication(command);
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
