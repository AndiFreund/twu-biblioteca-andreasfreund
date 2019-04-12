package com.twu.biblioteca;

public class ListBooksCommand implements LibraryExecutable {
    @Override
    public void execute(UserSession session) {
        System.out.println(session.getBookLibrary().listAvailableItems());
    }
}
