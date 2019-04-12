package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOutBook implements LibraryApplication {

    @Override
    public void execute(Session session) {
        ArrayList<Book> books = session.getBooks();
        int index = ApplicationsHelper.getIndexOfBook(books, session.getArgument());
        if (index == -1 || !books.get(index).isInStock()) {
            System.out.println("Sorry, that book is not available");
            return;
        }
        books.get(index).setInStock(false);

        System.out.println("Thank you! Enjoy the book");
    }
}
