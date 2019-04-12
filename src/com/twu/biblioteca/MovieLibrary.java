package com.twu.biblioteca;

public class MovieLibrary extends MediaLibrary {

    public MovieLibrary() {
        items.add(new Movie("movie1", "director1", "2001", "1"));
        items.add(new Movie("movie2", "director2", "2002", "2"));
        items.add(new Movie("movie3", "director3", "2003", "3"));
    }
}
