package com.twu.biblioteca;

public class Option {

    private String command;
    private String description;
    private LibraryApplication application;

    Option(String command, String description) {
        this.command = command;
        this.description = description;
        this.application = ApplicationFactory.getApplication(command);
    }

    @Override
    public String toString() {
        return command + ": " + description;
    }

    void execute(Session session) {
        application.execute(session);
    }
}
