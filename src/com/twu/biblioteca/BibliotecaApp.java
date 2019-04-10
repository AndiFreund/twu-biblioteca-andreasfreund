package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    static ArrayList<String> books = new ArrayList<String>(Arrays.asList("book1", "book2", "book3"));

    public static void main(String[] args) {
        System.out.println(welcomeMessag());
        System.out.println(getListOfBooks());
        /*while(true) {

        }*/
    }

    public static String welcomeMessag() {
        return "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!";
    }

    public static String getListOfBooks() {
        String result = new String();
        for (String book : books) {
            result += book + "\n";
        }
        return result;
    }
}
