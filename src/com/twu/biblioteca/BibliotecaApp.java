package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    //static ArrayList<String> books = new ArrayList<String>(Arrays.asList("book1", "book2", "book3"));
    static ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("book1", "author1", "2001"),
            new Book("book2", "author2", "2002"),
            new Book("book3", "author3", "2003")));

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
        for (Book book : books) {
            result += book.getTitle() + "\t\t" + book.getAuthor() + "\t\t" + book.getYear() + "\n";
        }
        return result;
    }
}
