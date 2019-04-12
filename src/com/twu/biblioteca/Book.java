package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String year;
    private boolean inStock;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.inStock = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return title + "\t\t" + author + "\t\t" + year;
    }
}
