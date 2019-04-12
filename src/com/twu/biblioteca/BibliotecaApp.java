package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Session session = new Session();
        session.setUp();

        System.out.println(session.displayWelcomeMessage());
        System.out.println(session.displayOptions());

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            session.executeLibraryApplication(input);
        }
    }

    static String showListAsString(ArrayList list) {
        String result = new String();
        for (Object item : list) {
            result += item.toString() + "\n";
        }
        return result;
    }

    static String extractCommand(String input) {
        return input.split(" ")[0];
    }

    static String extractArgument(String input) {
        String[] temp = input.split(" ", 2);
        return temp.length > 1 ? temp[1] : "";
    }
}