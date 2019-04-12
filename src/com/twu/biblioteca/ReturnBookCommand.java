package com.twu.biblioteca;

import java.util.List;

public class ReturnBookCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        List<Book> books = session.getBooks();
        int index = getIndexOfBook(books, session.getArgument());
        //what if book is in stock?
        if (index == -1) {
            System.out.println("That is not a valid book to return");
            return;
        }
        books.get(index).setInStock(true);

        System.out.println("Thank you for returning the book");
    }

    int getIndexOfBook(List<Book> books, String title) {
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
