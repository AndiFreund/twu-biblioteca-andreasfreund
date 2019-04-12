package com.twu.biblioteca;

public class ExitCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        System.exit(0);
    }
}
