package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReturnBookTests {


    UserSession session;

    //https://stackoverflow.com/a/1119559
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        session = new UserSession();
        session.setUp();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void returnBookSuccessMessageTest() {
        //given
        setUp();
        String result = "Thank you for returning the book\n";
        session.getBooks().get(0).setInStock(false);
        //when
        session.executeLibraryApplication("return book1");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void returnInvalidBookTest() {
        //given
        setUp();
        String result = "That is not a valid book to return\n";
        //when
        session.executeLibraryApplication("return book4");
        //then
        assertThat(outContent.toString(), is(result));
    }
}
