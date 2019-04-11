package com.twu.biblioteca;

public class ExitApplication implements LibraryApplication {

    @Override
    public void execute(Session session) {
        System.exit(0);
    }
}
