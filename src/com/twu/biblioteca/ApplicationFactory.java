package com.twu.biblioteca;

public class ApplicationFactory {

    public static LibraryApplication getApplication(String command) {
        switch (command) {
            case "quit":
                return new ExitApplication();
            case "list":
                return new ListBooksApplication();
            case "checkout":
                return new CheckOutBook();
            case "return":
                return new ReturnBook();
        }
        return null;
    }
}
