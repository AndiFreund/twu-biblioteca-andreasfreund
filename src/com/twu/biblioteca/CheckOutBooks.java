package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOutBooks implements LibraryApplication {

    @Override
    public void execute(Session session) {
        ArrayList<Book> books = session.getBooks();
        int index = getIndexOfBook(books, session.getArgument());
        if (index == -1 || !books.get(index).isInStock()) {
            System.out.println("Sorry, that book is not available");
            return;
        }
        books.get(index).setInStock(false);


        System.out.println("Thank you! Enjoy the book");
    }

    private int getIndexOfBook(ArrayList<Book> books, String title) {
        int result = -1;
        for (int i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).getTitle())) {
                result = i;
                break;
            }
        }

        return result;
    }
}
