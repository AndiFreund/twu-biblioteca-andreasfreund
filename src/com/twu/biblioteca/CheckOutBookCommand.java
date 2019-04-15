package com.twu.biblioteca;

public class CheckOutBookCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        if (session.isLoggedIn()) {
            boolean success = session.getBookLibrary().checkOutItemByTitle(session.getUser(), session.getArgument());
            if (success) {
                System.out.println("Thank you! Enjoy the book");
            } else {
                System.out.println("Sorry, that book is not available");
            }
        } else {
            System.out.println("You are not logged in. Please log in with the command \"login\"");
        }
    }
}
