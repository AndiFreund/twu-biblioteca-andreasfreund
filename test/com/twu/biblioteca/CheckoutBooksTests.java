package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckoutBooksTests {


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

    private String generateBookResultString(int from, int to) {
        StringBuilder builder = new StringBuilder();
        for(int i = from; i <= to; i++) {
            builder.append("book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n");
        }
        return builder.toString();
    }

    @Test
    public void checkoutExecutionTest() {
        //given
        setUp();
        String result = generateBookResultString(2, 3);
        //when
        session.executeLibraryApplication("checkout book1");
        //then
        assertThat(session.getBookLibrary().listAvailableItems(), is(result));
    }

    @Test
    public void checkoutSuccessfulTest() {
        //given
        setUp();
        String result = "Thank you! Enjoy the book\n";
        //when
        session.executeLibraryApplication("checkout book1");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void checkoutFailedTest() {
        //given
        setUp();
        String result = "Sorry, that book is not available\n";
        //when
        session.executeLibraryApplication("checkout book0");
        //then
        assertThat(outContent.toString(), is(result));
    }
}
