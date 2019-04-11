package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOutBooks implements LibraryApplication {

    @Override
    public void execute(Session session) {
        ArrayList<Book> books = session.getBooks();
        int result = -1;
        for (int i = 0; i < books.size(); i++) {
            if (session.getArgument().equals(books.get(i).getTitle())) {
                result = i;
                break;
            }
        }

        books.remove(result);
        System.out.println("Thank you! Enjoy the book");
    }
}
