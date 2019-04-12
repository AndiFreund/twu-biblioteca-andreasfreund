package com.twu.biblioteca;

public class ReturnBookCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        boolean success = session.getBookLibrary().returnItemByTitle(session.getArgument());
        if (success) {
            System.out.println("Thank you for returning the book");
        } else {
            System.out.println("That is not a valid book to return");
        }
    }
}
