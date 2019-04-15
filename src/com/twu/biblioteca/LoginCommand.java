package com.twu.biblioteca;

import java.util.Scanner;

public class LoginCommand implements LibraryExecutable {

    @Override
    public void execute(UserSession session) {
        String[] input = session.getArgument().split(" ");
        Authorizer authorizer = new Authorizer();
        User user = authorizer.validateCredentials(input[0], input[1]);
        if (user != null) {
            session.setUser(user);
            System.out.println("Successful login!");
        } else {
            System.out.println("Wrong credentials");
        }
    }
}
