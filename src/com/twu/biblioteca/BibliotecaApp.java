package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        UserSession session = new UserSession();
        session.setUp();

        System.out.println(session.displayWelcomeMessage());
        System.out.println(session.displayOptions());

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            session.executeLibraryApplication(input);
        }
    }
}