package com.twu.biblioteca;

import java.util.ArrayList;

public class ApplicationsHelper {

    static int getIndexOfBook(ArrayList<Book> books, String title) {
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
