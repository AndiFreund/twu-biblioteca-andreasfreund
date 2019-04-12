package com.twu.biblioteca;

public class Book extends MediaItem {

    private String author;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.inStock = true;
    }

    public String toString() {
        return title + "\t\t" + author + "\t\t" + year;
    }
}
