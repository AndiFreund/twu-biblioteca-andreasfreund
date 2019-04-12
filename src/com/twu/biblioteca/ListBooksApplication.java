package com.twu.biblioteca;

public class ListBooksApplication implements LibraryApplication {
    @Override
    public void execute(Session session) {
        System.out.println(session.displayAvailableBooks());
    }
}
