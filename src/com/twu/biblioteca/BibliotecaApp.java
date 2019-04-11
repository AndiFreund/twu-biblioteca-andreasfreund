package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Session session = new Session();
        session.setUp();

        System.out.println(session.displayWelcomeMessage());
        //System.out.println(getListOfBooks());
        System.out.println(session.displayOptions());

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.next();
            switch (input) {
                case "0":
                    return;
                case "1":
                    System.out.println(session.displayBooks());
                    break;
                default:
                    System.out.println("Please select a valid options!");
                    System.out.println(session.displayOptions());
                    break;
            }
        }
    }

    public static String showListAsString(ArrayList list) {
        String result = new String();
        for (Object item : list) {
            result += item.toString() + "\n";
        }
        return result;
    }
}