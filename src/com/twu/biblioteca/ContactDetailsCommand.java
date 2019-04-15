package com.twu.biblioteca;

public class ContactDetailsCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        if (session.isLoggedIn()) {
            System.out.println(session.getUser().toString());
        } else {
            System.out.println("Please log in with command \"login\"");
        }
    }
}
