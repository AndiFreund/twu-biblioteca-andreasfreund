package com.twu.biblioteca;

public class Movie extends MediaItem {

    private String director;
    private String rating;

    public Movie(String title, String director, String year, String rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.inStock = true;
    }

    public String toString() {
        return title + "\t\t" + director + "\t\t" + year + "\t\t" + rating;
    }
}
