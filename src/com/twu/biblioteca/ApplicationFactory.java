package com.twu.biblioteca;

public class ApplicationFactory {

    public static LibraryApplication getApplication(int num) {
        switch (num) {
            case 0:
                return new ExitApplication();
            case 1:
                return new CheckOutBooks();
        }
        return null;
    }
}
