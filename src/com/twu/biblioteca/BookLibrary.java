package com.twu.biblioteca;

public class BookLibrary extends MediaLibrary {

    public BookLibrary() {
        items.add(new Book("book1", "author1", "2001"));
        items.add(new Book("book2", "author2", "2002"));
        items.add(new Book("book3", "author3", "2003"));
    }
}
