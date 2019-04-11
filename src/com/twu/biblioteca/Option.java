package com.twu.biblioteca;

public class Option {

    private int num;
    private String description;
    private LibraryApplication application;

    Option(int num, String description) {
        this.num = num;
        this.description = description;
        this.application = ApplicationFactory.getApplication(num);
    }

    @Override
    public String toString() {
        return num + ": " + description;
    }

    void execute(Session session) {
        application.execute(session);
    }
}
