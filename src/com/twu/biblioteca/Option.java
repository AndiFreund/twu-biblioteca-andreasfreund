package com.twu.biblioteca;

public class Option {

    private int num;
    private String description;

    public Option(int num, String description) {
        this.num = num;
        this.description = description;
    }

    @Override
    public String toString() {
        return num + ": " + description;
    }
}
