package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary extends MediaLibrary {

    public BookLibrary() {
        items.add(new Book("book1", "author1", "2001"));
        items.add(new Book("book2", "author2", "2002"));
        items.add(new Book("book3", "author3", "2003"));
    }

    @Override
    public int size() {
        return items.size();
    }
}
