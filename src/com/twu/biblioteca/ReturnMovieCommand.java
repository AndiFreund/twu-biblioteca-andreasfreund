package com.twu.biblioteca;

public class ReturnMovieCommand implements LibraryExecutable {
    @Override
    public void execute(UserSession session) {
        boolean success = session.getMovieLibrary().returnItemByTitle(session.getArgument());
        if (success) {
            System.out.println("Thank you for returning the movie");
        } else {
            System.out.println("That is not a valid movie to return");
        }
    }
}
