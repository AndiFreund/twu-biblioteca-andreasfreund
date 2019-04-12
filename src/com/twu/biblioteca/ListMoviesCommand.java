package com.twu.biblioteca;

public class ListMoviesCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        System.out.println(session.getMovieLibrary().listAvailableItems());
    }
}
