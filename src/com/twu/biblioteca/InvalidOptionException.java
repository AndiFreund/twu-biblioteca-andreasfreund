package com.twu.biblioteca;

public class InvalidOptionException extends Exception {

    @Override
    public String toString() {
        return "Please select a valid options!";
    }
}
