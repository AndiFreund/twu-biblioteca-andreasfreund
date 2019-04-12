package com.twu.biblioteca;

import java.util.List;

public class CheckOutBookCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        boolean success = session.getBookLibrary().checkOutItemByTitle(session.getArgument());
        if (success) {
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("Sorry, that book is not available");
        }
    }
}
