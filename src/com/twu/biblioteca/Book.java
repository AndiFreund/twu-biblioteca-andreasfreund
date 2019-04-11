package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + "\t\t" + author + "\t\t" + year;
    }
}
