package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOutBooks implements LibraryApplication {

    @Override
    public void execute(Session session) {
        int index = getIndexOfBook(session.getBooks(), session.getArgument());
        if (index == -1) {
            System.out.println("Sorry, that book is not available");
            return;
        }
        session.getBooks().remove(index);

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
