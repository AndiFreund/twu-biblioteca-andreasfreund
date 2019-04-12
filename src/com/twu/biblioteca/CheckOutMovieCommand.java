package com.twu.biblioteca;

public class CheckOutMovieCommand implements LibraryExecutable {
    @Override
    public void execute(UserSession session) {
        boolean success = session.getMovieLibrary().checkOutItemByTitle(session.getArgument());
        if (success) {
            System.out.println("Thank you! Enjoy the movie");
        } else {
            System.out.println("Sorry, that movie is not available");
        }
    }
}
