package com.twu.biblioteca;

import java.util.ArrayList;

public class ReturnBook implements LibraryApplication {

    @Override
    public void execute(Session session) {
        ArrayList<Book> books = session.getBooks();
        int index = ApplicationsHelper.getIndexOfBook(books, session.getArgument());
        //what if book is in stock?
        if (index == -1) {
            System.out.println("That is not a valid book to return");
            return;
        }
        books.get(index).setInStock(true);

        System.out.println("Thank you for returning the book");
    }
}
