package com.twu.biblioteca;

import java.util.Scanner;

public class CheckOutBooks implements LibraryApplication {

    @Override
    public void execute(Session session) {
        System.out.println(session.displayBooks());

        /*Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            System.out.println(input);
            break;
        }*/
    }
}
