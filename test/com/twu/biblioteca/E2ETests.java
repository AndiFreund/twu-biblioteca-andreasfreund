package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class E2ETests {

    //https://stackoverflow.com/a/1119559
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    //private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        //System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        //System.setErr(originalErr);
    }

    @Ignore
    @Test
    public void correctWelcomeMessage() {
        //given
        //when
        //then
        BibliotecaApp.main(new String[0]);
        assertEquals("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!\n", outContent.toString());
    }

    @Test
    public void welcomeMessage() {
        //given
        //when
        String message = BibliotecaApp.welcomeMessag();
        //then
        assertThat("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!", is(equalTo(message)));
    }

    @Test
    public void listOfBooks() {
        //given
        String fakeList = "book1\nbook2\nbook3\n";
        //when
        String message = BibliotecaApp.getListOfBooks();
        //then
        assertThat(fakeList, is(equalTo(message)));
    }
}
