package com.twu.biblioteca;

public class CheckOutMovieCommand implements LibraryExecutable {
    @Override
    public void execute(UserSession session) {
        if(session.isLoggedIn()) {
            boolean success = session.getMovieLibrary().checkOutItemByTitle(session.getUser(), session.getArgument());
            if (success) {
                System.out.println("Thank you! Enjoy the movie");
            } else {
                System.out.println("Sorry, that movie is not available");
            }
        } else {
            System.out.println("You are not logged in. Please log in with the command \"login\"");
        }
    }
}
